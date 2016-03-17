import a_la_orden.Offer
import a_la_orden.Tag
import a_la_orden.User

class BootStrap {

    def init = { servletContext ->
        // tag example
        def tag = new Tag(
                title: "Música"
        )
        if (tag.validate())
            tag.save()
        else
            tag.errors.allErrors.each { println it }

        // offer example
        def offer = new Offer(
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
        if (offer.validate())
            offer.save()
        else
            offer.errors.allErrors.each { println it }

        // user example
        def user = new User(
                username: "maasencioh",
                password: "12345",
                firstName: "Miguel",
                lastName: "Asencio",
                email: "maasencioh@gmail.com",
                gender: "M",
                admin: true,
                offers: []
        )
        user.offers.add(offer)
        if (user.validate())
            user.save()
        else
            user.errors.allErrors.each { println it }
    }
    def destroy = {
    }
}
