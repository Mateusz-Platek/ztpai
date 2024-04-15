import {
    Carousel,
    CarouselContent,
    CarouselItem,
    CarouselNext,
    CarouselPrevious,
} from "@/components/ui/carousel"
import { Button } from "@/components/ui/button";

export default function Page() {
    return (
        <div className="flex flex-col gap-6">
            <div className="flex gap-6">
                <div className="w-2/3 px-20 bg-secondary">
                    <Carousel className="h-full">
                        <CarouselContent>
                            <CarouselItem>1</CarouselItem>
                            <CarouselItem>2</CarouselItem>
                            <CarouselItem>3</CarouselItem>
                        </CarouselContent>
                        <CarouselPrevious />
                        <CarouselNext />
                    </Carousel>
                </div>
                <div className="w-1/3 flex flex-col gap-2">
                    <div className="text-2xl font-bold">Opel Insignia</div>
                    <ul className="flex gap-4">
                        <li>2013</li>
                        <li>Diesel</li>
                        <li>260000 km</li>
                        <li>2000 cm3</li>
                    </ul>
                    <div className="text-2xl font-bold">50000 PLN</div>
                    <div>Warsaw</div>
                    <Button>Show number</Button>
                    <Button>Send email</Button>
                </div>
            </div>
            <div className="font-bold text-xl">Details</div>
            <div className="grid grid-cols-4">
                <div>Make:</div>
                <div>Opel</div>
                <div>Model:</div>
                <div>Insignia</div>
                <div>Generation:</div>
                <div>A</div>
                <div>Production year:</div>
                <div>2013</div>
                <div>Mileage:</div>
                <div>260000 km</div>
                <div>Engine size:</div>
                <div>2000 cm3</div>
                <div>Power:</div>
                <div>140 KM</div>
                <div>Drivetrain:</div>
                <div>FWD</div>
                <div>Color:</div>
                <div>Black</div>
                <div>Seats:</div>
                <div>5</div>
                <div>Doors:</div>
                <div>4</div>
                <div>Transmission:</div>
                <div>Automatic</div>
                <div>Body type:</div>
                <div>Sedan</div>
                <div>Condition:</div>
                <div>Used</div>
                <div>Damage:</div>
                <div>Not damaged</div>
            </div>
            <div className="font-bold text-xl">Description</div>
            <div>
                This well-maintained SUV is your ticket to versatility and comfort on the road.
                With its spacious interior, smooth handling, and fuel-efficient engine,
                it&apos;s perfect for daily commutes or weekend getaways.
                This RAV4 ensures a safe and enjoyable driving experience for you and your passengers.
                Don&apos;t miss out on this opportunity to own a trusted companion for all your journeys.
            </div>
            <div className="font-bold text-xl">Features</div>
            <div className="grid grid-cols-2">
                <div>ABS</div>
                <div>ESP</div>
                <div>Climate control</div>
                <div>Rear park assist</div>
                <div>Front park assist</div>
                <div>Camera 360</div>
                <div>Cruise control</div>
            </div>
        </div>
    );
}