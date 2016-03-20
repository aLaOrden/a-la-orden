package a_la_orden

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Demand)
class DemandSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "nulls"() {
        expect: "crea una demanda"
        def demand = new Demand (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title   | description | deadline | state    | solved | valid
        null    | "?"         | 123      | "activo" | false  | false
        "curso" | null        | 123      | "activo" | false  | false
        "curso" | "?"         | null     | "activo" | false  | false
        "curso" | "?"         | 123      | null     | false  | false
        "curso" | "?"         | 123      | "activo" | null   | false
        "curso" | "?"         | 123      | "activo" | false  | true
    }

    void "title"() {
        expect: "crea una demanda"
        def demand = new Demand (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title    | description | deadline | state    | solved | valid
        null     | "?"         | 123      | "activo" | false  | false
        "c"      | "?"         | 123      | "activo" | false  | false
        "a" * 60 | "?"         | 123      | "activo" | false  | false
        "curso"  | "?"         | 123      | "activo" | false  | true
    }

    void "blank"() {
        expect: "crea una demanda"
        def demand = new Demand (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title    | description | deadline | state    | solved | valid
        "curso"  | null        | 123      | "activo" | false  | false
        "curso"  | ""          | 123      | "activo" | false  | false
        "curso"  | "?"         | 123      | "activo" | false  | true
    }

    void "lista de estados"() {
        expect: "crea una demanda"
        def demand = new Demand (
                title: title,
                description: description,
                deadline: deadline,
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title    | description | deadline | state       | solved | valid
        "curso"  | "?"         | 123      | "activo"    | false  | true
        "curso"  | "?"         | 123      | "pausado"   | false  | true
        "curso"  | "?"         | 123      | "cancelado" | false  | true
        "curso"  | "?"         | 123      | "otro"      | false  | false
    }
}
