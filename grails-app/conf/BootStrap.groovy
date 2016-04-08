import a_la_orden.Demand
import a_la_orden.Offer
import a_la_orden.Score
import a_la_orden.Tag
import a_la_orden.User
import a_la_orden.Role
import a_la_orden.UserRole

class BootStrap {

    def init = { servletContext ->
        // tag example
        def tag = new Tag(
                title: "Musica"
        )
        if (tag.validate()) tag.save()
        else tag.errors.allErrors.each { println it }

        // offer example
        def offer = new Offer(
                title: "Cursos de organo",
                description: "Hace 3 años dicto cursos de organo, soy muy bueno",
                deadline: new Date().time,
                state: "activo",
                tags: [],
                latitude: 4.636487,
                longitude: -74.083313,
                price: 30000
        )
        offer.tags.add(tag)
        if (offer.validate()) offer.save()
        else offer.errors.allErrors.each { println it }

        def tag2 = new Tag(
                title: "Matematicas"
        )
        if (tag.validate()) tag.save()
        else tag.errors.allErrors.each { println it }
        def offer2 = new Offer(
                title: "Matem'aticas avanzadas",
                description: "profesor de calCULo avnazado y profundo",
                deadline: new Date().time,
                state: "activo",
                tags: [],
                latitude: 4.636487,
                longitude: -74.083313,
                price: 30000
        )
        offer2.tags.add(tag2)
        if (offer2.validate()) offer2.save()
        else offer2.errors.allErrors.each { println it }

        // demand example
        def demand = new Demand(
                title: "Cursos de guitarra",
                description: "Como es posible que nadie dicte curso de guitarra?",
                deadline: new Date().time,
                state: "activo",
                tags: [],
                solved: false
        )
        demand.tags.add(tag)
        if (demand.validate()) demand.save()
        else demand.errors.allErrors.each { println it }

        // score example
        def score = new Score(
                score: 5,
                description: "Muy habil",
                date: new Date(2012, 07, 16).time,
                offer: offer
        )
        if (score.validate()) score.save()
        else score.errors.allErrors.each { println it }

        // role example
        /*def role = new Role (
                authority: "Cliente"
        )
        if (role.validate()) role.save()
        else role.errors.allErrors.each { println it }*/

        // user example
        def user = new User(
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

        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()

        //UserRole.create user, adminRole, true
        UserRole.create user, userRole, true
    }
    def destroy = {
    }
}
