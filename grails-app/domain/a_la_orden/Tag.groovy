package a_la_orden

class Tag {

    String title

    static belongsTo = Service

    static constraints = {
        title nullable: false, size: 5..50
    }
}
