package a_la_orden

class Offer extends Service {

    Float   latitude
    Float   longitude
    Integer price
    String  youtubeLink
    String  photoLink

    static constraints = {
        latitude    nullable: false
        longitude   nullable: false
        price       nullable: false, min: 0
        youtubeLink nullable: true, url: true
        photoLink   nullable: true, url: true
    }
}
