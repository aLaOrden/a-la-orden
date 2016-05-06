package a_la_orden

import grails.rest.RestfulController

class UserController extends RestfulController {
    static responseFormats = ['json', 'xml']

    UserController() {
        super(User)
    }

    def username () {
        try {
            def criteria = User.createCriteria()
            def user = criteria.get {
                eq('username', params.username)
            }
            def queryMap = new HashMap(user.properties)
            queryMap.remove("offers")
            queryMap.remove("favorites")
            queryMap.remove("demands")
            queryMap.remove("password")
            def scores = queryMap.remove("scores")
            def scoresAvg = getScoresAverage(scores)
            queryMap.put("scoreAvg", scoresAvg)
            respond queryMap
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{"error": "'+ e +'"}'
        }
    }

    def getScoresAverage(def scores){
        def average = 0;
        for (int i = 0; i < scores.size(); i++) {
            Score myScore = scores[i]
            average += myScore.score
        }
        average /= scores.size()
        return average;
    }

    def index(){
        try {
            def users = User.getAll()
            respond users.collect {
                [
                        id         : users.id[0],
                        avatarLink : users.avatarLink[0],
                        firstName  : users.firstName[0],
                        lastName   : users.lastName[0],
                        email      : users.email[0],
                        phone      : users.phone[0],
                        gender     : users.gender[0]
                ]
            }
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render '{"error": "'+ e +'"}'
        }
    }

    def newUser(){
        def user = new User (
                username: params.username as String,
                password: params.pass as String,
                firstName: params.name as String,
                lastName: params.surname as String,
                email: params.email as String,
                gender: params.gender as String,
                admin: false,
                offers: [],
                demands: [],
                scores: []
        )
        if (user.validate()) user.save()
        else user.errors.allErrors.each { println it }
    }

    def login(){
        try {
            String username = params.username
            String password = params.password
            def user = User.findByUsername(username)
            if (user == null)
                render (status:403, text:'{"access": "denied", "reason": "invalid username"}')
            else if (user.password == password) {
                def queryMap = new HashMap(user.properties)
                queryMap.remove("offers")
                queryMap.remove("favorites")
                queryMap.remove("demands")
                queryMap.remove("password")
                def scores = queryMap.remove("scores")
                def scoresAvg = getScoresAverage(scores)
                queryMap.put("scoreAvg", scoresAvg)
                render(status: 200, contentType: "application/json") {
                    queryMap
                }
            }
            else
                render (status:403, text:'{"access": "denied", "reason": "invalid password"}')
        }
        catch (Exception e) {
            response.setContentType("application/json")
            render (status:500, '{"error": "'+ e +'"}')
        }
    }
}