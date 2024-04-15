import SearchCar from "@/components/search-car";
import CoreSearch from "@/components/core-search";

export default function Page() {
    return (
        <>
            <search className="pb-8">
                <CoreSearch />
            </search>
            <section className="flex flex-col gap-12">
                <SearchCar/>
                <SearchCar/>
                <SearchCar/>
            </section>
        </>
    );
}