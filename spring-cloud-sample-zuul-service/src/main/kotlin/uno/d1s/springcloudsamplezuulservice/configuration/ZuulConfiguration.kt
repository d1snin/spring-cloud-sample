package uno.d1s.springcloudsamplezuulservice.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.cloud.netflix.zuul.filters.RouteLocator
import org.springframework.cloud.netflix.zuul.web.ZuulController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import uno.d1s.springcloudsamplezuulservice.configuration.processor.ZuulBeanPostProcessor


/**
 * Fix for Zuul configuration with Spring Boot 2.5.x + Zuul - "NoSuchMethodError: ErrorController.getErrorPath()":
 */
@Configuration
@EnableZuulProxy
class ZuulConfiguration {

    /**
     * Constructs a new bean post-processor for Zuul.
     *
     * @param routeLocator    the route locator.
     * @param zuulController  the Zuul controller.
     * @param errorController the error controller.
     * @return the new bean post-processor.
     */
    @Bean
    fun zuulBeanPostProcessor(
        @Autowired routeLocator: RouteLocator,
        @Autowired zuulController: ZuulController,
        @Autowired(required = false) errorController: ErrorController
    ): ZuulBeanPostProcessor {
        return ZuulBeanPostProcessor(routeLocator, zuulController)
    }
}