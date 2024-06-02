import SearchCar from "@/components/search-car";
import CoreSearch from "@/components/core-search";
import {
    getBodyTypes,
    getColors,
    getConditions,
    getDamageTypes,
    getDrivetrains, getFuelTypes,
    getMakes,
    getOffers, getTransmissions
} from "@/lib/actions";

export default async function Page({
    searchParams
}: {
    searchParams: { [key: string]: string | string[] | undefined }
}) {
    let urlSearchParams = new URLSearchParams();

    Object.entries(searchParams).forEach(([key, value]) => {
        if (value != undefined) {
            urlSearchParams.append(key.toString(), value.toString());
        }
    });

    let offers = await getOffers(urlSearchParams.toString());
    let makes = await getMakes();
    let colors = await getColors();
    let bodyTypes = await getBodyTypes();
    let drivetrains = await getDrivetrains();
    let transmissions = await getTransmissions();
    let fuelTypes = await getFuelTypes();
    let conditions = await getConditions();
    let damageTypes = await getDamageTypes();

    return (
        <>
            <search className="pb-8">
                <CoreSearch
                    makes={makes}
                    colors={colors}
                    bodyTypes={bodyTypes}
                    drivetrains={drivetrains}
                    transmissions={transmissions}
                    fuelTypes={fuelTypes}
                    conditions={conditions}
                    damageTypes={damageTypes}
                />
            </search>
            <section className="flex flex-col gap-12">
                {offers.map((offerData: any) => (<SearchCar key={offerData.id} offer={offerData}/>))}
            </section>
        </>
    );
}