package a_la_orden

import grails.converters.JSON
import grails.rest.RestfulController

class DemandController extends RestfulController {
    static responseFormats = ['json', 'xml']

    DemandController() {
        super(Demand)
    }


    def title() {
        try {
            def demands
            if (params.id == null) {
                demands = Demand.findAll();
            } else {
                def criteria = Demand.createCriteria();
                demands = criteria.list {
                    like('title', '%' + params.id + '%')
                }
            }
            def allDemands = demands.collect {
                [
                        id         : demands.id[0],
                        title      : demands.title[0],
                        description: demands.description[0],
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