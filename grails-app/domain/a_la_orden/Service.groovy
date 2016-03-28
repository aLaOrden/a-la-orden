package a_la_orden

class Service {

    String title
    String description
    String state

    static hasMany = [tags: Tag]

    static constraints = {
        title       nullable: false, size: 5..50
        description nullable: false, blank: false
        state       nullable: false, inList: ["activo", "pendiente", "cancelado", "finalizado", "reportado"]
        tags        nullable: true
    }
}
