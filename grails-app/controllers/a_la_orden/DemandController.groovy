package a_la_orden

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured('ROLE_ADMIN')
class DemandController extends RestfulController {
    static responseFormats = ['json', 'xml']

    DemandController() {
        super(Demand)
    }
}