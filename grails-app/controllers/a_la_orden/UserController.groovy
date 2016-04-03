package a_la_orden

import grails.rest.RestfulController

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']

    UserController() {
        super(User)
    }

    def username () {
        try {
            def a = User.findByUsername(params.username as String)
            respond a.collect {
                [
                        avatar   : a.avatarLink,
                        firstName: a.firstName,
                        lastName : a.lastName,
                        email    : a.email,
                        phone    : a.phone,
                        gender   : a.gender,
                        scores   : a.scores,
                        offers   : a.offers,
                        demands  : a.demands,
                        favorites: a.favorites
                ]
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error: "'+ e +'"}'
        }
    }

    def index(){
        try {
            def users = User.getAll()
            respond users.collect {
                [
                        avatar   : users.avatarLink,
                        firstName: users.firstName,
                        lastName : users.lastName,
                        email    : users.email,
                        phone    : users.phone,
                        gender   : users.gender
                ]
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error: "'+ e +'"}'
        }
    }

    def newUser(){
        def user = new User (
                username: params.username as String,
                password: params.pass as String,
                firstName: params.name as String,
                lastName: params.surname as String,
                email: params.email as String,
                gender: params.gender as String,
                admin: false,
                offers: [],
                demands: [],
                scores: []
        )
        if (user.validate()) user.save()
        else user.errors.allErrors.each { println it }
    }
}