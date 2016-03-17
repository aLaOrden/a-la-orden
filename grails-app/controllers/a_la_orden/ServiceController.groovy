package a_la_orden

import grails.rest.RestfulController

class ServiceController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ServiceController() {
        super(Service)
    }
}