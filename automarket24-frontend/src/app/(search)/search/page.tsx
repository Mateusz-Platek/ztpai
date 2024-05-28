import SearchCar from "@/components/search-car";
import CoreSearch from "@/components/core-search";

async function getOffers(searchParams: string) {
    let response = await fetch("http://localhost:8080/offers?" + searchParams);
    return response.json();
}

async function getMakes() {
    let response = await fetch("http://localhost:8080/makes");
    return response.json();
}

async function getColors() {
    let response = await fetch("http://localhost:8080/colors");
    return response.json();
}

async function getBodyTypes() {
    let response = await fetch("http://localhost:8080/body-types");
    return response.json();
}

async function getDrivetrains() {
    let response = await fetch("http://localhost:8080/drivetrains");
    return response.json();
}

async function getTransmissions() {
    let response = await fetch("http://localhost:8080/transmissions");
    return response.json();
}

async function getFuelTypes() {
    let response = await fetch("http://localhost:8080/fuel-types");
    return response.json();
}

async function getConditions() {
    let response = await fetch("http://localhost:8080/conditions");
    return response.json();
}

async function getDamageTypes() {
    let response = await fetch("http://localhost:8080/damage-types");
    return response.json();
}

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
                <SearchCar/>
                <SearchCar/>
                <SearchCar/>
            </section>
        </>
    );
}