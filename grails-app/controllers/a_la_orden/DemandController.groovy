package a_la_orden

import grails.rest.RestfulController
import groovy.time.TimeCategory

class DemandController extends RestfulController {
    static responseFormats = ['json', 'xml']

    DemandController() {
        super(Demand)
    }

    def index() {
        Date date;
        use(TimeCategory) {
            date = new Date() - 30.days
        }
        try {
            def demands
            def criteria = Demand.createCriteria();
            demands = criteria.list {
                gt('deadline', date.time)
            }
            def allOffers = demands.collect {
                [
                        id         : demands.id[0],
                        title      : demands.title[0],
                        description: demands.description[0],
                        deadline   : demands.deadline[0],
                        state      : demands.state[0],
                        solved     : demands.solved[0]
                ]
            }

            if (allOffers.size() == 0) {
                render '[{"Resultado":"No se han encontrado coincidencias"}]'
            } else {
                respond allOffers
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error: "' + e + '"}'
        }
    }

    def title() {
        try {
            def demands
            if (params.title == null && params.id == null) {
                demands = Demand.findAll();
            } else {
                def criteria = Demand.createCriteria();
                demands = criteria.list {
                    ilike('title', '%' + params.title + '%')
                }
            }
            def allDemands = demands.collect {
                [
                        id         : demands.id[0],
                        title      : demands.title[0],
                        description: demands.description[0],
                        deadline   : demands.deadline[0],
                        state      : demands.state[0],
                        solved     : demands.solved[0]
                ]
            }

            if (allDemands.size() == 0) {
                render '[{"Resultado":"No se han encontrado coincidencias"}]'
            } else {
                respond allDemands
            }

        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error: "' + e + '"}'
        }
    }


}