import SearchCar from "@/components/search-car";
import CoreSearch from "@/components/core-search";

export async function getMakes() {
    let response = await fetch("http://localhost:8080/makes");
    return response.json();
}

export async function getColors() {
    let response = await fetch("http://localhost:8080/colors");
    return response.json();
}

export async function getBodyTypes() {
    let response = await fetch("http://localhost:8080/body-types");
    return response.json();
}

export async function getDrivetrains() {
    let response = await fetch("http://localhost:8080/drivetrains");
    return response.json();
}

export async function getTransmissions() {
    let response = await fetch("http://localhost:8080/transmissions");
    return response.json();
}

export async function getFuelTypes() {
    let response = await fetch("http://localhost:8080/fuel-types");
    return response.json();
}

export async function getConditions() {
    let response = await fetch("http://localhost:8080/conditions");
    return response.json();
}

export async function getDamageTypes() {
    let response = await fetch("http://localhost:8080/damage-types");
    return response.json();
}

export default async function Page() {
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