import a_la_orden.Demand
import a_la_orden.Offer
import a_la_orden.Score
import a_la_orden.Tag
import a_la_orden.User

class BootStrap {

    def init = { servletContext ->
        // tag example
        def tag = new Tag (
                title: "Música"
        )
        if (tag.validate()) tag.save()
        else tag.errors.allErrors.each { println it }

        // offer example
        def offer = new Offer (
                title: "Cursos de organo",
                description: "Hace 3 años dicto cursos de organo, soy muy bueno",
                deadline: new Date(),
                state: "activo",
                tags: [],
                latitude: 4.636487,
                longitude: -74.083313,
                price: 30000
        )
        offer.tags.add(tag)
        if (offer.validate()) offer.save()
        else offer.errors.allErrors.each { println it }

        // demand example
        def demand = new Demand (
                title: "Cursos de guitarra",
                description: "Como es posible que nadie dicte curso de guitarra?",
                deadline: new Date(),
                state: "activo",
                tags: [],
                solved: false
        )
        demand.tags.add(tag)
        if (demand.validate()) demand.save()
        else demand.errors.allErrors.each { println it }

        // score example
        def score = new Score (
                score: 5,
                description: "Muy habil",
                date: new Date(2012, 07, 16),
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
        user.offers.add(offer)
        user.demands.add(demand)
        user.scores.add(score)
        if (user.validate()) user.save()
        else user.errors.allErrors.each { println it }
    }
    def destroy = {
    }
}
