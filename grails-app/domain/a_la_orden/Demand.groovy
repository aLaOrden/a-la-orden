package a_la_orden

class Demand {

    // Service
    String title
    String description
    String state

    // Demand
    Boolean solved
    Long deadline

    static hasMany = [tags: Tag]

    static belongsTo = [
            User,
            Tag
    ]

    static constraints = {
        title       nullable: false, size: 5..50
        description nullable: false, blank: false
        state       nullable: false, inList: ["activo", "pendiente", "cancelado", "finalizado", "reportado"]
        tags        nullable: true
        solved      nullable: false
        deadline    nullable: false
    }
}
