import {HeartIcon} from "@radix-ui/react-icons";
import Image from "next/image";
import Link from "next/link";

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
    id: number;
    price: number;
    postTime: Date;
    location: string;
    car: Car;
}

export default function SearchCar({ offer }: { offer: Offer }) {
    const date = new Date(offer.postTime).toLocaleDateString();

    return (
        <Link href={"/search/offer/" + offer.id}>
            <div className="h-64 shadow-md rounded bg-secondary p-5 gap-8 flex">
                <div className="w-1/4 relative">
                    <Image src={"http://localhost:6020/" + offer.car.photos[0].path}
                           alt="Car photo."
                           fill={true}
                           className="object-cover rounded"
                           quality={100}
                    />
                </div>
                <div className="w-2/4 flex flex-col justify-between">
                    <div className="font-bold text-2xl">{offer.car.make.name} {offer.car.model.name} {offer.car.generation != null && offer.car.generation.name}</div>
                    <ul className="flex gap-4">
                        <li>{offer.car.mileage} km</li>
                        <li>{offer.car.fuelType.name}</li>
                        <li>{offer.car.transmission.name}</li>
                        <li>{offer.car.productionYear}</li>
                        <li>{offer.car.power} KM</li>
                        <li>{offer.car.engineSize} cm3</li>
                    </ul>
                    <div>{offer.location}</div>
                    <div>Published {date}</div>
                </div>
                <div className="w-1/4 flex flex-col justify-between items-end">
                    <div className="font-bold text-2xl">{offer.price} PLN</div>
                    <HeartIcon className="h-6 w-6"/>
                </div>
            </div>
        </Link>
    );
}