package uno.d1s.springcloudsampleservicetwo.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import uno.d1s.springcloudsamplecore.domain.AnotherSimpleDocument

@Repository
interface AnotherSimpleDocumentRepository : MongoRepository<AnotherSimpleDocument, String> {

    fun findAllByIdIn(ids: List<String>): List<AnotherSimpleDocument>
}