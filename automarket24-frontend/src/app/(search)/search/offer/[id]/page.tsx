import {
    Carousel,
    CarouselContent,
    CarouselItem,
    CarouselNext,
    CarouselPrevious,
} from "@/components/ui/carousel"
import { Button } from "@/components/ui/button";
import Image from "next/image";

interface User {
    id: number,
    email: string,
    phoneNumber: string,
    location: string
}

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

interface Offer {
    id: number,
    postTime: string,
    description: string,
    price: number,
    user: User
    car: Car
}

export default async function Page({params}: {params: {id: number}}) {
    async function getOffer() {
        let response = await fetch("http://localhost:8080/offers/" + params.id, {cache: "no-store"});
        return response.json();
    }

    let data: Offer = await getOffer();

    return (
        <div className="flex flex-col gap-6">
            <div className="flex gap-6">
                <div className="w-2/3 h-[500px] px-20 bg-secondary">
                    <Carousel className="h-full">
                        <CarouselContent className="h-full">
                            {data.car.photos.map(
                                (photo) => (<CarouselItem key={photo.id} className="relative">
                                <Image src={"http://localhost:6020/" + photo.path}
                                       alt="Car photo."
                                       fill={true}
                                       className="object-cover rounded"
                                       quality={100}
                                />
                                </CarouselItem>)
                            )}
                        </CarouselContent>
                        <CarouselPrevious />
                        <CarouselNext />
                    </Carousel>
                </div>
                <div className="w-1/3 flex flex-col gap-2">
                    <div className="text-2xl font-bold">{data.car.make.name} {data.car.model.name}</div>
                    <ul className="flex gap-4">
                        <li>{data.car.productionYear}</li>
                        <li>{data.car.fuelType.name}</li>
                        <li>{data.car.mileage} km</li>
                        <li>{data.car.engineSize} cm3</li>
                    </ul>
                    <div className="text-2xl font-bold">{data.price} PLN</div>
                    <div>{data.user.location}</div>
                    <Button>Show number</Button>
                    <Button>Send email</Button>
                </div>
            </div>
            <div className="font-bold text-xl">Details</div>
            <div className="grid grid-cols-4">
                <div>Make:</div>
                <div>{data.car.make.name}</div>
                <div>Model:</div>
                <div>{data.car.model.name}</div>
                {data.car.generation != null ? <div>Generation:</div> : null}
                {data.car.generation != null ? <div>{data.car.generation.name}</div> : null}
                <div>Production year:</div>
                <div>{data.car.productionYear}</div>
                <div>Mileage:</div>
                <div>{data.car.mileage} km</div>
                <div>Engine size:</div>
                <div>{data.car.engineSize} cm3</div>
                <div>Power:</div>
                <div>{data.car.power} KM</div>
                <div>Drivetrain:</div>
                <div>{data.car.drivetrain.name}</div>
                <div>Color:</div>
                <div>{data.car.color.name}</div>
                <div>Seats:</div>
                <div>{data.car.seats}</div>
                <div>Doors:</div>
                <div>{data.car.doors}</div>
                <div>Transmission:</div>
                <div>{data.car.transmission.name}</div>
                <div>Body type:</div>
                <div>{data.car.bodyType.name}</div>
                <div>Condition:</div>
                <div>{data.car.condition.name}</div>
                <div>Damage:</div>
                <div>{data.car.damageType.name}</div>
            </div>
            <div className="font-bold text-xl">Description</div>
            <div>
                {data.description}
                This well-maintained SUV is your ticket to versatility and comfort on the road.
                With its spacious interior, smooth handling, and fuel-efficient engine,
                it&apos;s perfect for daily commutes or weekend getaways.
                This RAV4 ensures a safe and enjoyable driving experience for you and your passengers.
                Don&apos;t miss out on this opportunity to own a trusted companion for all your journeys.
            </div>
            <div className="font-bold text-xl">Features</div>
            <div className="grid grid-cols-2">
                {data.car.features.map((feature) => (<div key={feature.id}>{feature.name}</div>))}
            </div>
        </div>
    );
}