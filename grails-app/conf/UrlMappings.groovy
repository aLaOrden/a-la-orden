class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
                action = [GET: "show", PUT: "update", DELETE: "delete", POST: "save"]
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')

        // API
        "/users/username/$username?"(controller: "user", action: "username")
        "/users/login/"(controller: "user", action: "login", method: "POST")
        "/users"(resources: "user")
        "/tags"(resources: "tag")
        "/offers/tag/$title?"(controller: "offer", action: "classified")
        "/offers"(resources: "offer")
        "/offers/title/$title?"(controller: "offer", action: "title")
        "/demands"(resources: "demand")
        "/demands/title/$title?"(controller: "demand", action: "title")
        "/scores"(resources: "score")
    }
}
