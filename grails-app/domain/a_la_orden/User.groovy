package a_la_orden

class User {

    String  username
    String  password
    String  firstName
    String  lastName
    String  email
    Number  phone
    String  avatarLink
    String  gender
    Boolean admin

    static hasMany = [favorites: User]

    static constraints = {
        username   nullable: false, size: 5..15, unique: true
        password   nullable: false, size: 5..15
        firstName  nullable: false, size: 5..30
        lastName   nullable: false, size: 5..30
        email      nullable: false, size: 5..30, unique: true, email: true
        phone      nullable: true,  size: 7..13
        avatarLink nullable: true,  size: 5..15, unique: true
        gender     nullable: false, inList: ["M", "F"]
        admin      nullable: false

        favorites  nullable: true
    }
}
