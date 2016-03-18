package a_la_orden

class Score {

    Integer score
    String  description
    Long    date
    Offer   offer

    static belongsTo = User

    static constraints = {
        score       nullable: false, range: 1..5
        description nullable: true
        date        nullable: false
        offer       nullable: false
    }
}
