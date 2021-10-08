package uno.d1s.springcloudsampleserviceone.repository

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import uno.d1s.springcloudsamplecore.domain.SimpleDocument

@Repository
interface SimpleDocumentRepository : MongoRepository<SimpleDocument, String>