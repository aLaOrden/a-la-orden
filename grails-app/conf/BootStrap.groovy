import a_la_orden.Service
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

        // service example
        def service = new Service(
                title: "Cursos de organo",
                description: "Hace 3 años dicto cursos de organo, soy muy bueno",
                deadline: new Date(),
                state: "activo",
                tags: []
        )
        service.tags.add(tag)
        if (service.validate())
            service.save()
        else
            service.errors.allErrors.each { println it }

        // user example
        def user = new User(
                username: "maasencioh",
                password: "12345",
                firstName: "Miguel",
                lastName: "Asencio",
                email: "maasencioh@gmail.com",
                gender: "M",
                admin: true,
                services: []
        )
        user.services.add(service)
        if (user.validate())
            user.save()
        else
            user.errors.allErrors.each { println it }
    }
    def destroy = {
    }
}
