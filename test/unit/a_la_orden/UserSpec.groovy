package a_la_orden

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "nulls"() {
        expect: "crea un usuario"
        def user = new User (
                username: username,
                password: password,
                firstName: firstName,
                lastName: lastName,
                email: email,
                phone: phone,
                avatarLink: avatarLink,
                gender: gender,
                admin: admin
        )
        user.validate() == valid

        where: "valida la demanda"
        username | password | firstName | lastName | email            | phone   | avatarLink          | gender | admin | valid
        null     | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | null     | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | null      | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | null     | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | null             | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | null    | "http://github.com" | "M"    | false | true
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | null                | "M"    | false | true
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | null   | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | null  | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | true
    }

    void "size"() {
        expect: "crea un usuario"
        def user = new User (
                username: username,
                password: password,
                firstName: firstName,
                lastName: lastName,
                email: email,
                phone: phone,
                avatarLink: avatarLink,
                gender: gender,
                admin: admin
        )
        user.validate() == valid

        where: "valida la demanda"
        username | password | firstName | lastName | email            | phone   | avatarLink          | gender | admin | valid
        "a"      | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "a" * 16 | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "a" * 4  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "a" * 16 | "a"       | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "a" * 31  | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "a"      | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "a" * 31 | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "a"              | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "a" * 31         | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "a" * 4             | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "a" * 31            | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com" | 1234567 | "http://github.com" | "M"    | false | true
    }

    void "email, url y lista"() {
        expect: "crea un usuario"
        def user = new User (
                username: username,
                password: password,
                firstName: firstName,
                lastName: lastName,
                email: email,
                phone: phone,
                avatarLink: avatarLink,
                gender: gender,
                admin: admin
        )
        user.validate() == valid

        where: "valida la demanda"
        username | password | firstName | lastName | email             | phone   | avatarLink          | gender | admin | valid
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james"      | 1234567 | "http://github.com" | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.bond" | 1234567 | "github.com"        | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com"  | 1234567 | "github"            | "M"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com"  | 1234567 | "http://github.com" | "A"    | false | false
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com"  | 1234567 | "http://github.com" | "F"    | false | true
        "bond"   | "00007"  | "james"   | "bond"   | "bond@james.com"  | 1234567 | "http://github.com" | "M"    | false | true
    }
}
