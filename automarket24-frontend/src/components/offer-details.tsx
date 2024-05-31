interface Car {
    id: number,
    productionYear: number,
    mileage: number,
    power: number,
    engineSize: number,
    seats: number,
    doors: number,
    make: {
        id: number,
        name: string
    },
    model: {
        id: number,
        name: string
    },
    generation: {
        id: number,
        name: string
    },
    bodyType: {
        id: number,
        name: string
    },
    transmission: {
        id: number,
        name: string
    },
    drivetrain: {
        id: number,
        name: string
    },
    color: {
        id: number,
        name: string
    },
    fuelType: {
        id: number,
        name: string
    },
    damageType: {
        id: number,
        name: string
    },
    condition: {
        id: number,
        name: string
    },
    photos: {
        id: number,
        path: string
    }[],
    features: {
        id: number,
        name: string
    }[]
}

export default function OfferDetails({
    description, car
}: {
    description: string, car: Car
}) {
    return (
        <div className="flex flex-col gap-6">
            <div className="font-bold text-xl">Details</div>
            <div className="grid grid-cols-2 md:grid-cols-4">
                <div>Make:</div>
                <div>{car.make.name}</div>
                <div>Model:</div>
                <div>{car.model.name}</div>
                {car.generation != null ? <div>Generation:</div> : null}
                {car.generation != null ? <div>{car.generation.name}</div> : null}
                <div>Production year:</div>
                <div>{car.productionYear}</div>
                <div>Mileage:</div>
                <div>{car.mileage} km</div>
                <div>Engine size:</div>
                <div>{car.engineSize} cm3</div>
                <div>Power:</div>
                <div>{car.power} KM</div>
                <div>Drivetrain:</div>
                <div>{car.drivetrain.name}</div>
                <div>Color:</div>
                <div>{car.color.name}</div>
                <div>Seats:</div>
                <div>{car.seats}</div>
                <div>Doors:</div>
                <div>{car.doors}</div>
                <div>Transmission:</div>
                <div>{car.transmission.name}</div>
                <div>Body type:</div>
                <div>{car.bodyType.name}</div>
                <div>Condition:</div>
                <div>{car.condition.name}</div>
                <div>Damage:</div>
                <div>{car.damageType.name}</div>
            </div>
            <div className="font-bold text-xl">Description</div>
            <div>{description}</div>
            <div className="font-bold text-xl">Features</div>
            <div className="grid grid-cols-1 md:grid-cols-2">
                {car.features.map((feature: any) => (<div key={feature.id}>{feature.name}</div>))}
            </div>
        </div>
    )
}