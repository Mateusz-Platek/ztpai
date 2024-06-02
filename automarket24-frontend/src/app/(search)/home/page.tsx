import HomeCar from "@/components/home-car";
import HomeSearch from "@/components/home-search";
import {getMakes} from "@/lib/actions/actions";
import {getLatestOffers} from "@/lib/actions/offer-actions";

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
                    {offers.map((offerData: any) => (<HomeCar key={offerData.id} offer={offerData}/>))}
                </div>
            </section>
        </>
    );
}