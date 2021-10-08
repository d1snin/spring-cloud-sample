package uno.d1s.springcloudsampleservicetwo.controller.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import uno.d1s.springcloudsamplecore.client.AnotherSimpleClient
import uno.d1s.springcloudsamplecore.domain.AnotherSimpleDocument
import uno.d1s.springcloudsampleservicetwo.service.AnotherSimpleService

@RestController
class AnotherSimpleControllerImpl @Autowired constructor(
    val anotherSimpleService: AnotherSimpleService
) : AnotherSimpleClient {

    override fun getAnotherSimpleDocumentById(id: String) =
        ResponseEntity.of(anotherSimpleService.getAnotherSimpleDocumentById(id))

    override fun getAllAnotherSimpleDocuments(): ResponseEntity<List<AnotherSimpleDocument>> =
        ResponseEntity.ok(anotherSimpleService.getAllAnotherSimpleDocuments())

    override fun getAllAnotherSimpleDocumentsByIdIn(ids: List<String>): ResponseEntity<List<AnotherSimpleDocument>> =
        ResponseEntity.ok(anotherSimpleService.getAllAnotherSimpleDocumentsByIdIn(ids))

    override fun createAnotherSimpleDocument(doc: AnotherSimpleDocument): ResponseEntity<AnotherSimpleDocument> =
        ResponseEntity.ok(anotherSimpleService.createAnotherSimpleDocument(doc))
}