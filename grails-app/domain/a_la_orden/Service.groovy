package a_la_orden

class Service {

    String title
    String description
    Date   deadline
    String state

    static constraints = {
        title       nullable: false, size: 5..50
        description nullable: false, blank: false
        deadline    nullable: false
        state       nullable: false, inList: ["activo", "pausado", "cancelado"]
    }
}
