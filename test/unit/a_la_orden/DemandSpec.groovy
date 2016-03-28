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
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title   | description | state    | solved | valid
        null    | "?"         | "activo" | false  | false
        "curso" | null        | "activo" | false  | false
        "curso" | "?"         | null     | false  | false
        "curso" | "?"         | "activo" | null   | false
        "curso" | "?"         | "activo" | false  | true
    }

    void "title"() {
        expect: "crea una demanda"
        def demand = new Demand (
                title: title,
                description: description,
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title    | description | state    | solved | valid
        null     | "?"         | "activo" | false  | false
        "c"      | "?"         | "activo" | false  | false
        "a" * 60 | "?"         | "activo" | false  | false
        "curso"  | "?"         | "activo" | false  | true
    }

    void "blank"() {
        expect: "crea una demanda"
        def demand = new Demand (
                title: title,
                description: description,
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title    | description | state    | solved | valid
        "curso"  | null        | "activo" | false  | false
        "curso"  | ""          | "activo" | false  | false
        "curso"  | "?"         | "activo" | false  | true
    }

    void "lista de estados"() {
        expect: "crea una demanda"
        def demand = new Demand (
                title: title,
                description: description,
                state: state,
                solved: solved
        )
        demand.validate() == valid

        where: "valida la demanda"
        title    | description | state        | solved | valid
        "curso"  | "?"         | "activo"     | false  | true
        "curso"  | "?"         | "pendiente"  | false  | true
        "curso"  | "?"         | "cancelado"  | false  | true
        "curso"  | "?"         | "finalizado" | false  | true
        "curso"  | "?"         | "reportado"  | false  | true
        "curso"  | "?"         | "otro"       | false  | false
    }
}
