package a_la_orden

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured('ROLE_ADMIN')
class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']

    UserController() {
        super(User)
    }

    @Secured('ROLE_USER')
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