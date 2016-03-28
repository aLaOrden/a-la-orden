package a_la_orden

import grails.test.mixin.TestFor
import org.hibernate.id.TableGenerator
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Tag)
class TagSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "title"() {
        expect: "crea una etiqueta"
        def tag = new Tag (
                title: title
        )
        tag.validate() == valid

        where: "valida la etiqueta"
        title    | valid
        null     | false
        ""       | false
        "a"      | false
        "a" * 60 | false
        "12345"  | true
    }
}
