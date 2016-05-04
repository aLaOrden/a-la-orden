package a_la_orden

import grails.rest.RestfulController
import grails.converters.JSON


class OfferController extends RestfulController {
    static responseFormats = ['json', 'xml']

    OfferController() {
        super(Offer)
    }

    def classified() {
        try {
            def tagId = Tag.findByTitle(params.title as String).id
            def c = Offer.createCriteria()
            respond c.list {
                tags { idEq(tagId) }
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error:"' + e + '"}'
        }
    }


    def title() {
        try {
            def offers
            if(params.id == null){
                offers = Offer.findAll();
            }else {
                def criteria = Offer.createCriteria();
                offers = criteria.list {
                    like('title', '%' + params.id + '%')
                }
            }
            def allOffers = offers.collect {
                [
                        id         : offers.id[0],
                        title      : offers.title[0],
                        description: offers.description[0],
                        deadline   : offers.deadline[0],
                        state      : offers.state[0],
                        latitude   : offers.latitude[0],
                        longitude  : offers.longitude[0],
                        price      : offers.price[0]
                ]
            }

            if(allOffers.size() == 0){
                render '[{"Resultado":"No se han encontrado coincidencias"}]'
            }else {
                respond allOffers
            }

        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error: "' + e + '"}'
        }
    }


}