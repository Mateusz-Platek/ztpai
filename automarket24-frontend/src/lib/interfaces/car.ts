export default interface Car {
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