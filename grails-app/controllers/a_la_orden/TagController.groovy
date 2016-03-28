package a_la_orden

import grails.rest.RestfulController

class TagController extends RestfulController {
    static responseFormats = ['json', 'xml']

    TagController() {
        super(Tag)
    }
}