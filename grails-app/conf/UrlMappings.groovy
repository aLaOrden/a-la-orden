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
        "/users" (resources: "user")
        "/tags" (resources: "tag")
        "/offers" (resources: "offer")
	}
}
