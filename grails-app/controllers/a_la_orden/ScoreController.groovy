package a_la_orden

import grails.rest.RestfulController

class ScoreController extends RestfulController {
    static responseFormats = ['json', 'xml']

    ScoreController() {
        super(Score)
    }
}