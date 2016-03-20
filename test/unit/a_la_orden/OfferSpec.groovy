package a_la_orden

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Offer)
class OfferSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "nulls"() {
        expect: "crea una oferta"
        def offer = new Offer (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                latitude: latitude,
                longitude: longitude,
                price: price,
                youtubeLink: youtubeLink,
                photoLink: photoLink
        )
        offer.validate() == valid

        where: "valida la oferta"
        title   | description | deadline | state    | latitude | longitude | price | youtubeLink          | photoLink           | valid
        null    | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso" | null        | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso" | "?"         | null     | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso" | "?"         | 123      | null     | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso" | "?"         | 123      | "activo" | null     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso" | "?"         | 123      | "activo" | 12.3     | null      | 123   | "http://youtube.com" | "http://github.com" | false
        "curso" | "?"         | 123      | "activo" | 12.3     | -1.23     | null  | "http://youtube.com" | "http://github.com" | false
        "curso" | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | null                 | "http://github.com" | true
        "curso" | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | null                | true
        "curso" | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
    }

    void "title"() {
        expect: "crea una oferta"
        def offer = new Offer (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                latitude: latitude,
                longitude: longitude,
                price: price,
                youtubeLink: youtubeLink,
                photoLink: photoLink
        )
        offer.validate() == valid

        where: "valida la oferta"
        title    | description | deadline | state    | latitude | longitude | price | youtubeLink          | photoLink           | valid
        null     | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "c"      | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "a" * 60 | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso"  | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
    }

    void "blank"() {
        expect: "crea una oferta"
        def offer = new Offer (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                latitude: latitude,
                longitude: longitude,
                price: price,
                youtubeLink: youtubeLink,
                photoLink: photoLink
        )
        offer.validate() == valid

        where: "valida la oferta"
        title    | description | deadline | state    | latitude | longitude | price | youtubeLink          | photoLink           | valid
        "curso"  | null        | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso"  | ""          | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
        "curso"  | "?"         | 123      | "activo" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
    }

    void "lista de estados"() {
        expect: "crea una oferta"
        def offer = new Offer (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                latitude: latitude,
                longitude: longitude,
                price: price,
                youtubeLink: youtubeLink,
                photoLink: photoLink
        )
        offer.validate() == valid

        where: "valida la oferta"
        title    | description | deadline | state       | latitude | longitude | price | youtubeLink          | photoLink           | valid
        "curso"  | "?"         | 123      | "activo"    | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
        "curso"  | "?"         | 123      | "pausado"   | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
        "curso"  | "?"         | 123      | "cancelado" | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
        "curso"  | "?"         | 123      | "otro"      | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | false
    }

    void "links"() {
        expect: "crea una oferta"
        def offer = new Offer (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                latitude: latitude,
                longitude: longitude,
                price: price,
                youtubeLink: youtubeLink,
                photoLink: photoLink
        )
        offer.validate() == valid

        where: "valida la oferta"
        title    | description | deadline | state       | latitude | longitude | price | youtubeLink          | photoLink           | valid
        "curso"  | "?"         | 123      | "activo"    | 12.3     | -1.23     | 123   | "thisisnotalink"     | "http://github.com" | false
        "curso"  | "?"         | 123      | "activo"    | 12.3     | -1.23     | 123   | "http://youtube.com" | "thisisnotalink"    | false
        "curso"  | "?"         | 123      | "activo"    | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
    }

    void "price"() {
        expect: "crea una oferta"
        def offer = new Offer (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                latitude: latitude,
                longitude: longitude,
                price: price,
                youtubeLink: youtubeLink,
                photoLink: photoLink
        )
        offer.validate() == valid

        where: "valida la oferta"
        title    | description | deadline | state       | latitude | longitude | price | youtubeLink          | photoLink           | valid
        "curso"  | "?"         | 123      | "activo"    | 12.3     | -1.23     | -1    | "http://youtube.com" | "http://github.com" | false
        "curso"  | "?"         | 123      | "activo"    | 12.3     | -1.23     | 0     | "http://youtube.com" | "http://github.com" | true
        "curso"  | "?"         | 123      | "activo"    | 12.3     | -1.23     | 123   | "http://youtube.com" | "http://github.com" | true
    }
}
