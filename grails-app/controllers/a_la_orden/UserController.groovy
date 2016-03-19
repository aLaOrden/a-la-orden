package a_la_orden

import grails.rest.RestfulController

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']

    UserController() {
        super(User)
    }

    def username () {
        try {
            respond User.findByUsername(params.username as String)
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error: "'+ e +'"}'
        }
    }
}