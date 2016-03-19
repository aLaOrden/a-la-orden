class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')

        // API
        "/users/username/$username?" (controller: "user", action: "username")
        "/users"   (resources: "user")
        "/tags"    (resources: "tag")
        "/offers/tag/$title?"(controller: "offer", action: "classified")
        "/offers"  (resources: "offer")
        "/demands" (resources: "demand")
        "/scores"  (resources: "score")
	}
}
