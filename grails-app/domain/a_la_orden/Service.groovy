package a_la_orden

class Service {

    String title
    String description
    Long   deadline
    String state

    static hasMany = [tags: Tag]

    static constraints = {
        title       nullable: false, size: 5..50
        description nullable: false, blank: false
        deadline    nullable: false
        state       nullable: false, inList: ["activo", "pendiente", "cancelado", "finalizado", "reportado"]

        tags        nullable: true
    }
}
