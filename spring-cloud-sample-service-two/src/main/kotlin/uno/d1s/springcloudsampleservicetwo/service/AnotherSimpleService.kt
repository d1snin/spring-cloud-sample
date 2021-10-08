package uno.d1s.springcloudsampleservicetwo.service

import uno.d1s.springcloudsamplecore.domain.AnotherSimpleDocument
import java.util.*

interface AnotherSimpleService {

    fun getAnotherSimpleDocumentById(id: String): Optional<AnotherSimpleDocument>

    fun getAllAnotherSimpleDocuments(): List<AnotherSimpleDocument>

    fun getAllAnotherSimpleDocumentsByIdIn(ids: List<String>): List<AnotherSimpleDocument>

    fun createAnotherSimpleDocument(doc: AnotherSimpleDocument): AnotherSimpleDocument
}