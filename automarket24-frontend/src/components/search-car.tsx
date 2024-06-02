import {HeartIcon} from "@radix-ui/react-icons";
import Image from "next/image";
import Link from "next/link";
import HomeOffer from "@/lib/interfaces/home-offer";

export default function SearchCar({ offer }: { offer: HomeOffer }) {
    const date = new Date(offer.postTime).toLocaleDateString();

    return (
        <Link href={"/search/offer/" + offer.id}>
            <div className="md:h-64 shadow-md rounded bg-secondary p-5 gap-2 md:gap-8 flex flex-col md:flex-row">
                <div className="md:w-1/4 min-h-32 relative">
                    <Image src={"http://localhost:6020/" + offer.car.photos[0].path}
                           alt="Car photo."
                           fill={true}
                           className="object-cover rounded"
                           quality={100}
                    />
                </div>
                <div className="md:w-2/4 flex flex-col gap-2 md:gap-0 justify-between">
                    <div className="font-bold text-2xl">{offer.car.make.name} {offer.car.model.name} {offer.car.generation != null && offer.car.generation.name}</div>
                    <ul className="flex flex-col md:flex-row gap-2">
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
                <div className="md:w-1/4 flex md:flex-col justify-between items-end">
                    <div className="font-bold text-2xl">{offer.price} PLN</div>
                    <HeartIcon className="h-6 w-6"/>
                </div>
            </div>
        </Link>
    );
}