package a_la_orden

import grails.rest.RestfulController
import grails.transaction.Transactional
import groovy.time.TimeCategory
import org.codehaus.groovy.grails.web.servlet.HttpHeaders

import static org.springframework.http.HttpStatus.CREATED

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
            def allDemands = demands.collectEntries() { Demand dmnd ->
                [
                        id         : demands.id,
                        title      : demands.title,
                        description: demands.description,
                        deadline   : demands.deadline,
                        state      : demands.state,
                        solved     : demands.solved
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
            def allDemands = demands.collectEntries() { Demand dmnd ->
                [
                        id         : demands.id,
                        title      : demands.title,
                        description: demands.description,
                        deadline   : demands.deadline,
                        state      : demands.state,
                        solved     : demands.solved
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
            render '{"error": "' + e + '"}'
        }
    }

    @Transactional
    def delete() {
        try {
            Demand demand = Demand.findById(params.id)
            if (demand == null) {
                render '{"resultado": "Esta demanda no existe"}'
            } else {
                demand.tags.clear()
                def users = User.findAll();
                for (int i = 0; i < users.size(); i++) {
                    users[i].removeFromDemands(demand)
                }
                demand.delete(flush:true)
                render '{"resultado": "La demanda a sido eliminada"}'
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{"error": "' + e + '"}'
        }
    }

    @Transactional
    def save(){
        try {
            Demand instance = new Demand()
            instance.title = params.title
            instance.description = params.description
            instance.state = params.state
            instance.solved = params.solved
            Date date
            use(TimeCategory) {
                date = new Date() + 60.days
            }
            instance.deadline = date.time
            instance.save flush: true

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: "${resourceName}.label".toString(), default: resourceClassName), instance.id])
                    redirect instance
                }
                '*' {
                    response.addHeader(HttpHeaders.LOCATION,
                            g.createLink(
                                    resource: this.controllerName, action: 'show',id: instance.id, absolute: true,
                                    namespace: hasProperty('namespace') ? this.namespace : null ))
                    respond instance, [status: CREATED]
                }
            }
        }catch (Exception e) {
            response.setContentType("application/json")
            render '{"error": "' + e + '"}'
        }
    }

}