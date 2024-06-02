import {Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious} from "@/components/ui/carousel";
import Image from "next/image";
import NumberButton from "@/components/number-button";
import {MapPinIcon} from "lucide-react";
import EmailButton from "@/components/email-button";
import {getUserData} from "@/lib/actions";
import Offer from "@/lib/interfaces/offer";

export default async function OfferMain({offer}: {offer: Offer}) {
    let userData = await getUserData();

    let path = '/login';
    if (userData !== null) {
        path = '/email?email=' + offer.user.email;
    }

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
            <div className="md:w-1/3 flex flex-col gap-3">
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
                <EmailButton path={path}/>
            </div>
        </div>
    )
}