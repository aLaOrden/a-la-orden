package a_la_orden

class Demand extends Service {

    Boolean solved
    Long deadline

    static belongsTo = User

    static constraints = {
        solved nullable: false
        deadline nullable: false
    }
}
