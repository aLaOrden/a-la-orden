package a_la_orden

class User {

    String  username
    String  password
    String  firstName
    String  lastName
    String  email
    Long    phone
    String  avatarLink
    String  gender
    Boolean admin

    static hasMany = [
            favorites: User,
            offers: Offer,
            demands: Demand,
            scores: Score
    ]

    static constraints = {
        username   nullable: false, size: 2..15, unique: true
        password   nullable: false, size: 5..15
        firstName  nullable: false, size: 2..30
        lastName   nullable: false, size: 2..30
        email      nullable: false, size: 5..30, unique: true, email: true
        phone      nullable: true,  size: 3..20
        avatarLink nullable: true,  size: 5..30, unique: true, url: true
        gender     nullable: false, inList: ["M", "F"]
        admin      nullable: false

        favorites  nullable: true
        offers     nullable: true
        demands    nullable: true
        scores     nullable: true
    }
}
