package uno.d1s.springcloudsamplecore.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Document
class AnotherSimpleDocument(
    @NotNull @NotBlank val name: String
) {

    @Id
    lateinit var id: String
}