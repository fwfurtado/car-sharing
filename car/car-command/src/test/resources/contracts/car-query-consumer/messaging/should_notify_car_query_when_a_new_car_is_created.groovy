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
                releaseYear: '2017',
                modelYear: '2017',
                licensePlate: 'ABC-1234',
                ownerId: '13e09757-95b4-4d7c-88cd-5678796bbdfd',
                ownerName: 'Fernando',
                ownerBio: 'Some bio here!',
                location: [-23.426478, -46.123456],
                status: 'WAITING_FOR_APPROVAL'
        )

    }

}
