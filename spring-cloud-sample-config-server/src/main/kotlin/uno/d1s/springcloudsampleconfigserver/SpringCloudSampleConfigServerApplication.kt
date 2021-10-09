package uno.d1s.springcloudsampleconfigserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudSampleConfigServerApplication

fun main(args: Array<String>) {
    runApplication<SpringCloudSampleConfigServerApplication>(*args)
}
