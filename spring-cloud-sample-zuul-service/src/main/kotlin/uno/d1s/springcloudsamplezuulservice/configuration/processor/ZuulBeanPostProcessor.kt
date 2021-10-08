package uno.d1s.springcloudsamplezuulservice.configuration.processor

import org.springframework.beans.BeansException
import org.springframework.beans.factory.config.BeanPostProcessor
import org.springframework.cglib.proxy.Enhancer
import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy
import org.springframework.cglib.proxy.NoOp
import org.springframework.cloud.netflix.zuul.filters.RouteLocator
import org.springframework.cloud.netflix.zuul.web.ZuulController
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping
import org.springframework.context.annotation.Configuration
import java.lang.reflect.Method

@Configuration
class ZuulBeanPostProcessor internal constructor(
    private val routeLocator: RouteLocator,
    private val zuulController: ZuulController
) : BeanPostProcessor {

    companion object {
        const val ERROR_PATH = "/error"
        const val METHOD = "lookupHandler"
    }

    @Throws(BeansException::class)
    override fun postProcessAfterInitialization(bean: Any, beanName: String): Any? {
        if (bean is ZuulHandlerMapping) {
            val ctor = ZuulHandlerMapping::class.java.constructors[0]

            return Enhancer().apply {
                setSuperclass(ZuulHandlerMapping::class.java)

                setCallbackFilter { method -> // only for lookupHandler
                    if (METHOD == method.name) {
                        0
                    } else {
                        1
                    }
                }

                setCallbacks(
                    arrayOf(
                        object : MethodInterceptor {
                            override fun intercept(
                                target: Any,
                                method: Method,
                                args: Array<Any>,
                                methodProxy: MethodProxy
                            ): Any? {

                                return if (ERROR_PATH == args[0]) {
                                    // by entering this branch we avoid the ZuulHandlerMapping.lookupHandler method to trigger the
                                    // NoSuchMethodError
                                    null
                                } else {
                                    methodProxy.invokeSuper(target, args)
                                }
                            }
                        }, NoOp.INSTANCE
                    )
                )
            }.create(ctor.parameterTypes, arrayOf(routeLocator, zuulController))
        }
        return bean
    }
}