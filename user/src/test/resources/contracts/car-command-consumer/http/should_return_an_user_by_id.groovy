
import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method GET()

        urlPath'/users/13e09757-95b4-4d7c-88cd-5678796bbdfd'

        headers {
            accept applicationJson()
        }
    }

    response {
        status OK()

        headers {
            contentType applicationJson()
        }

        body(
                id: fromRequest().path(1),
                name: 'Fernando',
                bio: 'Some bio here!',
                email: 'fernando@email.com'
        )
    }
}