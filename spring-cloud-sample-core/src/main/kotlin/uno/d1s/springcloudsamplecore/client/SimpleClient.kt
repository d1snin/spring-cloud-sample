package uno.d1s.springcloudsamplecore.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import uno.d1s.springcloudsamplecore.domain.SimpleDocument
import javax.validation.Valid

@RequestMapping("/simple")
@FeignClient("spring-cloud-sample-service-one")
interface SimpleClient {

    @GetMapping
    fun getAllSimpleDocuments(): ResponseEntity<List<SimpleDocument>>

    @PostMapping("/create")
    fun createSimpleDocument(@Valid @RequestBody doc: SimpleDocument): ResponseEntity<SimpleDocument>

    @PostMapping("/assignAnotherSimple")
    fun assignAnotherSimpleDocument(idAnotherSimple: String, idSimple: String): ResponseEntity<SimpleDocument>
}