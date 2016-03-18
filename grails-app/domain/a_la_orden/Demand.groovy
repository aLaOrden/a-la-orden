package a_la_orden

class Demand extends Service {

    Boolean solved

    static belongsTo = User

    static constraints = {
        solved nullable: false
    }
}
