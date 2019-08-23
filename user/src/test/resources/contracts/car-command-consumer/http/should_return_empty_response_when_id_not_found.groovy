import org.springframework.cloud.contract.spec.Contract
import org.springframework.cloud.contract.spec.internal.RegexPatterns


Contract.make {
    request {
        method GET()
        urlPath('/users/13330ed4-e197-4ee7-bda4-da12067f58fd')

        headers {
            accept(applicationJson())
        }
    }

    response {
        status NOT_FOUND()
    }
}