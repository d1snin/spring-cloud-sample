package uno.d1s.springcloudsamplecore.client

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uno.d1s.springcloudsamplecore.domain.AnotherSimpleDocument
import javax.validation.Valid

@RequestMapping("/anotherSimple")
@FeignClient("spring-cloud-sample-service-two")
interface AnotherSimpleClient {

    @GetMapping("/{id}")
    fun getAnotherSimpleDocumentById(@PathVariable id: String): ResponseEntity<AnotherSimpleDocument>

    @GetMapping
    fun getAllAnotherSimpleDocuments(): ResponseEntity<List<AnotherSimpleDocument>>

    @GetMapping("/ids")
    fun getAllAnotherSimpleDocumentsByIdIn(@RequestBody ids: List<String>): ResponseEntity<List<AnotherSimpleDocument>>

    @PostMapping("/create")
    fun createAnotherSimpleDocument(@RequestBody @Valid doc: AnotherSimpleDocument): ResponseEntity<AnotherSimpleDocument>
}