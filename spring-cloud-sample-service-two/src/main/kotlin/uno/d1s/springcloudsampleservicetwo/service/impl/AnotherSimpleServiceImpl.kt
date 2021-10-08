package uno.d1s.springcloudsampleservicetwo.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uno.d1s.springcloudsamplecore.domain.AnotherSimpleDocument
import uno.d1s.springcloudsampleservicetwo.repository.AnotherSimpleDocumentRepository
import uno.d1s.springcloudsampleservicetwo.service.AnotherSimpleService
import java.util.*

@Service
class AnotherSimpleServiceImpl @Autowired constructor(
    val anotherSimpleDocumentRepository: AnotherSimpleDocumentRepository
) : AnotherSimpleService {

    override fun getAnotherSimpleDocumentById(id: String): Optional<AnotherSimpleDocument> =
        anotherSimpleDocumentRepository.findById(id)

    override fun getAllAnotherSimpleDocuments(): List<AnotherSimpleDocument> =
        anotherSimpleDocumentRepository.findAll()

    override fun getAllAnotherSimpleDocumentsByIdIn(ids: List<String>): List<AnotherSimpleDocument> =
        anotherSimpleDocumentRepository.findAllByIdIn(ids)

    override fun createAnotherSimpleDocument(doc: AnotherSimpleDocument): AnotherSimpleDocument =
        anotherSimpleDocumentRepository.save(doc)
}