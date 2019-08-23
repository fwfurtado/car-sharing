import org.springframework.cloud.contract.spec.Contract

Contract.make {
    label 'registerCar'

    input {
        triggeredBy('registrationCar()')
    }

    outputMessage {
        sentTo('cars')

        headers {
            header("contentType", applicationJson())
        }

        body(
                id: 'ddbb7efa-7276-4112-8fb1-d9b1d07ab66b',
                model: 'Camaro',
                brand: 'CHEVROLET',
                ownerName: 'Fernando',
                location: [-23.426478, -46.123456],
                status: 'WAITING_FOR_APPROVAL'
        )

    }

}
