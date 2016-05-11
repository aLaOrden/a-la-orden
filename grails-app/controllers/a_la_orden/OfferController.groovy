package a_la_orden

import grails.rest.RestfulController
import groovy.time.TimeCategory


class OfferController extends RestfulController {
    static responseFormats = ['json', 'xml']

    OfferController() {
        super(Offer)
    }

    def index() {
        Date date;
        use(TimeCategory) {
            date = new Date() - 30.days
        }
        try {
            def offers
            def criteria = Offer.createCriteria();
            offers = criteria.list {
                gt('deadline', date.time)
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
            if (params.title == null) {
                offers = Offer.findAll();
            } else {
                def criteria = Offer.createCriteria();
                offers = criteria.list {
                    ilike('title', '%' + params.title + '%')
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

    def delete() {
        try {
            def offer = Offer.findById(params.id)
            if (offer == null) {
                render 'Esta oferta no existe'
            } else {
                offer.tags.clear()
                def users = User.findAll();
                for (int i = 0; i < users.size(); i++) {
                    users[i].removeFromOffers(offer)
                }
                def scores = Score.findAll();
                for (int i = 0; i < scores.size(); i++) {
                    if(scores[i].offer.id == offer.id){
                        scores[i].offer = null;
                    }
                }
                offer.delete(flush:true)
                render 'La oferta a sido eliminada'
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render 'La oferta no se pudo eliminar'
        }
    }

}