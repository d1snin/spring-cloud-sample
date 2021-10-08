package uno.d1s.springcloudsampleserviceone.configuration

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import uno.d1s.springcloudsamplecore.client.AnotherSimpleClient

@Configuration
@EnableFeignClients(clients = [AnotherSimpleClient::class])
class FeignClientsConfiguration 