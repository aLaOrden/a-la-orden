package a_la_orden

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable{

    transient springSecurityService

    String  username
    String  password
    String  firstName
    String  lastName
    String  email
    Number  phone
    String  avatarLink
    String  gender
    Boolean admin

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [
            favorites: User,
            offers: Offer,
            demands: Demand,
            scores: Score
    ]

    static constraints = {
        username   nullable: false, size: 2..15, unique: true
        password   nullable: false
        firstName  nullable: false, size: 2..30
        lastName   nullable: false, size: 2..30
        email      nullable: false, size: 5..30, unique: true, email: true
        phone      nullable: true
        avatarLink nullable: true,  size: 5..30, unique: true, url: true
        gender     nullable: false, inList: ["M", "F"]
        admin      nullable: false

        favorites  nullable: true
        offers     nullable: true
        demands    nullable: true
        scores     nullable: true
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this)*.role
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ?
                springSecurityService.encodePassword(password) :
                password
    }

    static transients = ['springSecurityService']

    static mapping = {
        password column: 'password'
    }

}
