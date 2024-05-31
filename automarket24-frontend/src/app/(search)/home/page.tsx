import HomeCar from "@/components/home-car";
import HomeSearch from "@/components/home-search";

interface Car {
    make: string;
    model: string;
    productionYear: number;
    mileage: number;
    power: number;
    engineSize: number;
    fuelType: string;
    photoPath: string;
}

interface Offer {
    id: number;
    price: number;
    car: Car;
}

export async function getMakes() {
    let response = await fetch("http://localhost:8080/makes");
    return response.json();
}

async function getLatestOffers() {
    let response = await fetch("http://localhost:8080/offers/latest", {cache: "no-store"});
    return response.json();
}

export default async function Page() {
    let makes = await getMakes();
    let offers = await getLatestOffers();

    return (
        <>
            <search className="pb-8">
                <HomeSearch makes={makes}/>
            </search>
            <section>
                <div className="pb-8 font-bold text-2xl">Highlighted offers</div>
                <div className="grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 md:justify-items-center gap-4 md:gap-12">
                    {offers.map((offerData: Offer) => (<HomeCar key={offerData.id} offer={offerData}/>))}
                </div>
            </section>
        </>
    );
}