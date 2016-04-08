package a_la_orden

import grails.plugin.springsecurity.annotation.Secured
import grails.rest.RestfulController

@Secured('ROLE_ADMIN')
class OfferController extends RestfulController {
    static responseFormats = ['json', 'xml']

    OfferController() {
        super(Offer)
    }

    def classified(){
        try{
            def tagId = Tag.findByTitle(params.title as String).id
            def c = Offer.createCriteria()
            respond c.list{
                tags{idEq(tagId)}
            }
        }
        catch (Exception e){
            response.setContentType("application/json")
            render '{error:"'+e+'"}'
        }
    }
}