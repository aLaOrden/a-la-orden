package a_la_orden

class Tag {

    String title

    static hasMany = [
            offers: Offer,
            demands: Demand
    ]

    static constraints = {
        title   nullable: false, size: 5..50
        offers  nullable: true
        demands nullable: true
    }
}
