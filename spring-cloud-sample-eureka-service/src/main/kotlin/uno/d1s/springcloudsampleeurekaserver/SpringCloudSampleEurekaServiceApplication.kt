package uno.d1s.springcloudsampleeurekaserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudSampleEurekaServerApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudSampleEurekaServerApplication>(*args)
}
