import a_la_orden.User

class BootStrap {

    def init = { servletContext ->
        def user = new User(
                username: "maasencioh",
                password: "12345",
                firstName: "Miguel",
                lastName: "Asencio",
                email: "maasencioh@gmail.com",
                gender: "M",
                admin: true
        )
        if (user.validate())
            user.save()
        else
            user.errors.allErrors.each { println it }
    }
    def destroy = {
    }
}
