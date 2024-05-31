import {Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious} from "@/components/ui/carousel";
import Image from "next/image";
import {EnvelopeClosedIcon, TargetIcon} from "@radix-ui/react-icons";
import {Button} from "@/components/ui/button";
import NumberButton from "@/components/number-button";
import {MapPin, MapPinIcon} from "lucide-react";

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

export default function OfferMain({offer}: {offer: Offer}) {
    return (
        <div className="flex flex-col md:flex-row gap-6">
            <div className="md:w-2/3 h-72 md:h-[500px] px-16 md:px-20 bg-secondary">
                <Carousel className="h-full">
                    <CarouselContent className="h-full">
                        {offer.car.photos.map(
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
                    <CarouselPrevious/>
                    <CarouselNext/>
                </Carousel>
            </div>
            <div className="md:w-1/3 flex flex-col gap-2">
                <div className="text-2xl font-bold">{offer.car.make.name} {offer.car.model.name}</div>
                <ul className="flex gap-4">
                    <li>{offer.car.productionYear}</li>
                    <li>{offer.car.fuelType.name}</li>
                    <li>{offer.car.mileage} km</li>
                    <li>{offer.car.engineSize} cm3</li>
                </ul>
                <div className="text-2xl font-bold">{offer.price} PLN</div>
                <div className="flex items-center gap-2"><MapPinIcon className="w-6 h-6" /> {offer.user.location}</div>
                <NumberButton phoneNumber={offer.user.phoneNumber} />
                <Button className="flex items-center gap-2"><EnvelopeClosedIcon className="w-6 h-6" /> Send email</Button>
            </div>
        </div>
    )
}