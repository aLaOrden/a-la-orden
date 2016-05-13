import a_la_orden.Demand
import a_la_orden.Offer
import a_la_orden.Score
import a_la_orden.Tag
import a_la_orden.User
import groovy.time.TimeCategory

class BootStrap {

    def init = { servletContext ->
        // tag example
        def tag = new Tag(
                title: "Musica"
        )
        if (tag.validate()) tag.save()
        else tag.errors.allErrors.each { println it }

        Date date;
        use(TimeCategory) {
            date = new Date() - 2.month
        }

        // offer example
        def offer = new Offer (
                title: "Cursos de organo",
                description: "Hace 3 años dicto cursos de organo, soy muy bueno",
                deadline: date.time,
                state: "activo",
                tags: [],
                latitude: 4.636487,
                longitude: -74.083313,
                price: 30000
        )
        offer.addToTags(tag)
        if (offer.validate()) offer.save()
        else offer.errors.allErrors.each { println it }

        def tag2 = new Tag (
                title: "Matematicas"
        )
        if (tag2.validate()) tag2.save()
        else tag2.errors.allErrors.each { println it }
        def offer2 = new Offer(
                title: "Matematicas avanzadas",
                description: "profesor de calculo avanzado y profundo",
                deadline: new Date().time,
                state: "activo",
                tags: [],
                latitude: 4.636487,
                longitude: -74.083313,
                price: 30000
        )
        offer2.addToTags(tag2)
        if (offer2.validate()) offer2.save()
        else offer2.errors.allErrors.each { println it }

        // demand example
        def demand = new Demand (
                title: "Cursos de guitarra",
                description: "Como es posible que nadie dicte curso de guitarra?",
                deadline: new Date().time,
                state: "activo",
                tags: [],
                solved: false
        )
        demand.addToTags(tag)
        if (demand.validate()) demand.save()
        else demand.errors.allErrors.each { println it }

        // score example
        def score = new Score (
                score: 5,
                description: "Muy habil",
                date: new Date(2012, 07, 16).time,
                offer: offer
        )
        if (score.validate()) score.save()
        else score.errors.allErrors.each { println it }

        // user example
        def user = new User (
                username: "maasencioh",
                password: "12345",
                firstName: "Miguel",
                lastName: "Asencio",
                email: "maasencioh@gmail.com",
                gender: "M",
                admin: true,
                offers: [],
                demands: [],
                scores: []
        )
        user.addToOffers(offer)
        user.addToDemands(demand)
        user.addToScores(score)
        if (user.validate()) user.save()
        else user.errors.allErrors.each { println it }

        // user example
        def user2 = new User (
                username: "erickvelasco11",
                password: "Erick.123",
                firstName: "Erick",
                lastName: "Velasco",
                email: "erickvelasco11@gmail.com",
                gender: "M",
                admin: true,
                offers: [],
                demands: [],
                scores: []
        )
        user2.addToOffers(offer)
        user2.addToDemands(demand)
        user2.addToScores(score)
        if (user2.validate()) user2.save()
        else user2.errors.allErrors.each { println it }
    }
    def destroy = {
    }
}
