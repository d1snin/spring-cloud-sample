package uno.d1s.springcloudsampleserviceone.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uno.d1s.springcloudsamplecore.client.AnotherSimpleClient
import uno.d1s.springcloudsamplecore.domain.SimpleDocument
import uno.d1s.springcloudsampleserviceone.repository.SimpleDocumentRepository
import uno.d1s.springcloudsampleserviceone.service.SimpleService
import kotlin.properties.Delegates

@Service
class SimpleServiceImpl @Autowired constructor(
    private val simpleDocumentRepository: SimpleDocumentRepository,
    private val anotherSimpleClient: AnotherSimpleClient
) : SimpleService {

    override fun getAllSimpleDocuments(): List<SimpleDocument> =
        simpleDocumentRepository.findAll()

    override fun createSimpleDocument(doc: SimpleDocument): SimpleDocument {
        doc.anotherSimpleDocumentsIds.let {
            if (it.isNotEmpty()) {
                it.forEach { id ->
                    if (!anotherSimpleClient.getAnotherSimpleDocumentById(id).hasBody()) {
                        throw IllegalArgumentException("Could not find an another simple document by provided id: $id")
                    }
                }
            }
        }

        return simpleDocumentRepository.save(doc)
    }

    override fun assignAnotherSimpleDocument(idAnotherSimple: String, idSimple: String): SimpleDocument {
        var result by Delegates.notNull<SimpleDocument>()

        simpleDocumentRepository.findById(idSimple).ifPresentOrElse({ simpleDoc ->
            result = anotherSimpleClient.getAnotherSimpleDocumentById(idAnotherSimple).body?.let {
                simpleDoc.apply {
                    anotherSimpleDocumentsIds += it.id
                }
            } ?: throw IllegalArgumentException("Could not find another simple document by id.")
        }) {
            throw IllegalArgumentException("Could not find simple document by id.")
        }

        return result
    }
}