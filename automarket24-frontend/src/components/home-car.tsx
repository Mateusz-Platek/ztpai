import Image from 'next/image';
import Link from 'next/link';
import HomeOffer from "@/lib/interfaces/home-offer";

export default function HomeCar({ offer }: { offer: HomeOffer }) {
    return (
        <Link href={"/search/offer/" + offer.id}>
            <div className="bg-secondary rounded w-full md:w-96 h-96 shadow-md">
                <div className="h-3/5 relative">
                    <Image src={"http://localhost:6020/" + offer.car.photoPath}
                           alt="Car photo."
                           fill={true}
                           className="object-cover rounded"
                           quality={100}
                    />
                </div>
                <div className="p-3 text-secondary-foreground h-2/5 flex flex-col justify-between">
                    <div className="font-bold text-xl">{offer.car.make} {offer.car.model}</div>
                    <ul className="flex justify-between">
                        <li>{offer.car.productionYear}</li>
                        <li>{offer.car.power} KM</li>
                        <li>{offer.car.engineSize} cm3</li>
                        <li>{offer.car.fuelType}</li>
                        <li>{offer.car.mileage} km</li>
                    </ul>
                    <div className="font-bold text-2xl">{offer.price} PLN</div>
                </div>
            </div>
        </Link>
    );
}