import HomeCar from "@/components/home-car";
import HomeSearch from "@/components/home-search";

export default async function Page() {
    return (
        <>
            <search className="pb-8">
                <HomeSearch />
            </search>
            <section>
                <div className="pb-8 font-bold text-2xl">Highlighted offers</div>
                <div className="grid grid-cols-3 justify-items-center gap-y-12">
                    <HomeCar/>
                    <HomeCar/>
                    <HomeCar/>
                    <HomeCar/>
                    <HomeCar/>
                    <HomeCar/>
                </div>
            </section>
        </>
    );
}