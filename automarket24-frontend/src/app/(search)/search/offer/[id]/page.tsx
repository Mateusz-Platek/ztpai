import {Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious} from "@/components/ui/carousel"
import {Button} from "@/components/ui/button";
import Image from "next/image";
import {TargetIcon} from "@radix-ui/react-icons";
import OfferDetails from "@/components/offer-details";

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
            <div className="flex flex-col md:flex-row gap-6">
                <div className="md:w-2/3 h-72 md:h-[500px] px-16 md:px-20 bg-secondary">
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
                <div className="md:w-1/3 flex flex-col gap-2">
                    <div className="text-2xl font-bold">{data.car.make.name} {data.car.model.name}</div>
                    <ul className="flex gap-4">
                        <li>{data.car.productionYear}</li>
                        <li>{data.car.fuelType.name}</li>
                        <li>{data.car.mileage} km</li>
                        <li>{data.car.engineSize} cm3</li>
                    </ul>
                    <div className="text-2xl font-bold">{data.price} PLN</div>
                    <div className="flex items-center gap-2"><TargetIcon className="w-6 h-6" />{ data.user.location}</div>
                    <Button>Show number</Button>
                    <Button>Send email</Button>
                </div>
            </div>
            <OfferDetails description={data.description} car={data.car} />
        </div>
    );
}