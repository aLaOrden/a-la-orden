package a_la_orden

class Offer {

    // Service
    String title
    String description
    String state

    // Offer
    Float   latitude
    Float   longitude
    Integer price
    String  youtubeLink
    String  photoLink
    Long    deadline

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
        latitude    nullable: false
        longitude   nullable: false
        price       nullable: false, min: 0
        youtubeLink nullable: true, url: true
        photoLink   nullable: true, url: true
        deadline    nullable: false
    }
}
