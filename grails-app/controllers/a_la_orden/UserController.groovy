package a_la_orden

import grails.rest.RestfulController

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']

    UserController() {
        super(User)
    }

    def username () {
        try {
            def a = User.findByUsername(params.username as String)
            respond a.collect {
                [
                        avatar   : a.avatarLink,
                        firstName   : a.firstName,
                        lastName : a.lastName,
                        email    : a.email,
                        phone    : a.phone,
                        gender   : a.gender,
                        scores   : a.scores,
                        offers  : a.offers,
                        demands : a.demands,
                        favorites: a.favorites
                ]
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{error: "'+ e +'"}'
        }
    }
}
/*
def userInfo = [
                    ["avatar: " , a.avatarLink],
                    ["firstName: " , a.firstName],
                    ["lastName: " , a.lastName],
                    ["email: " , a.email],
                    ["phone: " , a.phone],
                    ["gender: " , a.gender],
                    ["scores: " , a.scores],
                    ["offers: " , a.offers],
                    ["demands: " , a.demands],
                    ["favorites: " , a.favorites]
            ]
 */
//[{"class":"a_la_orden.User","id":1,"admin":true,"avatarLink":null,"demands":[{"class":"a_la_orden.Demand","id":3}],"email":"maasencioh@gmail.com","favorites":[],"firstName":"Miguel","gender":"M","lastName":"Asencio","offers":[{"class":"a_la_orden.Offer","id":1}],"password":"12345","phone":null,"scores":[{"class":"a_la_orden.Score","id":1}],"username":"maasencioh"}]