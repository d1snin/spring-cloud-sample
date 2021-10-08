package uno.d1s.springcloudsampleserviceone.service

import uno.d1s.springcloudsamplecore.domain.SimpleDocument

interface SimpleService {

    fun getAllSimpleDocuments(): List<SimpleDocument>

    fun createSimpleDocument(doc: SimpleDocument): SimpleDocument

    fun assignAnotherSimpleDocument(idAnotherSimple: String, idSimple: String): SimpleDocument
}