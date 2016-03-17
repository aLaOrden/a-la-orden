package a_la_orden

import grails.rest.RestfulController

class OfferController extends RestfulController {
    static responseFormats = ['json', 'xml']

    OfferController() {
        super(Offer)
    }
}