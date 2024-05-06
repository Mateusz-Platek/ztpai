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

export default async function Page() {
    async function getLatest() {
        let response = await fetch("http://localhost:8080/offers/latest", {cache: "no-store"});
        return response.json();
    }

    let data = await getLatest();

    return (
        <>
            <search className="pb-8">
                <HomeSearch />
            </search>
            <section>
                <div className="pb-8 font-bold text-2xl">Highlighted offers</div>
                <div className="grid grid-cols-3 justify-items-center gap-y-12">
                    {data.map((offerData: Offer) => (<HomeCar key={offerData.id} offer={offerData}/>))}
                </div>
            </section>
        </>
    );
}