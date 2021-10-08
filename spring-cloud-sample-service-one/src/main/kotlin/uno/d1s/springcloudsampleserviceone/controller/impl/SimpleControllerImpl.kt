package uno.d1s.springcloudsampleserviceone.controller.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController
import uno.d1s.springcloudsamplecore.client.SimpleClient
import uno.d1s.springcloudsamplecore.domain.SimpleDocument
import uno.d1s.springcloudsampleserviceone.service.SimpleService

@RestController
class SimpleControllerImpl @Autowired constructor(
    private val simpleService: SimpleService
) : SimpleClient {

    override fun getAllSimpleDocuments(): ResponseEntity<List<SimpleDocument>> =
        ResponseEntity.ok(simpleService.getAllSimpleDocuments())

    override fun createSimpleDocument(doc: SimpleDocument): ResponseEntity<SimpleDocument> =
        ResponseEntity.ok(simpleService.createSimpleDocument(doc))

    override fun assignAnotherSimpleDocument(
        idAnotherSimple: String,
        idSimple: String
    ): ResponseEntity<SimpleDocument> =
        ResponseEntity.ok(simpleService.assignAnotherSimpleDocument(idAnotherSimple, idSimple))
}