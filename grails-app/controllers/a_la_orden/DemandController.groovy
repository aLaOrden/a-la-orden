package a_la_orden

import grails.rest.RestfulController

class DemandController extends RestfulController {
    static responseFormats = ['json', 'xml']

    DemandController() {
        super(Demand)
    }
}