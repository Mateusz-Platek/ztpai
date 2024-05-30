import AddOffer from "@/components/add-offer";

async function getMakes() {
    let response = await fetch("http://localhost:8080/makes", { cache: "no-store" });
    return response.json();
}

async function getColors() {
    let response = await fetch("http://localhost:8080/colors", { cache: "no-store" });
    return response.json();
}

async function getBodyTypes() {
    let response = await fetch("http://localhost:8080/body-types", { cache: "no-store" });
    return response.json();
}

async function getDrivetrains() {
    let response = await fetch("http://localhost:8080/drivetrains", { cache: "no-store" });
    return response.json();
}

async function getTransmissions() {
    let response = await fetch("http://localhost:8080/transmissions", { cache: "no-store" });
    return response.json();
}

async function getFuelTypes() {
    let response = await fetch("http://localhost:8080/fuel-types", { cache: "no-store" });
    return response.json();
}

async function getConditions() {
    let response = await fetch("http://localhost:8080/conditions", { cache: "no-store" });
    return response.json();
}

async function getDamageTypes() {
    let response = await fetch("http://localhost:8080/damage-types", { cache: "no-store" });
    return response.json();
}

async function getFeatures() {
    let response = await fetch("http://localhost:8080/features", { cache: "no-store" });
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
    let features = await getFeatures();

    return (
        <div className="px-64">
            <div className="text-3xl font-bold pb-4">Create an offer</div>
            <AddOffer
                makes={makes}
                colors={colors}
                bodyTypes={bodyTypes}
                drivetrains={drivetrains}
                transmissions={transmissions}
                fuelTypes={fuelTypes}
                conditions={conditions}
                damageTypes={damageTypes}
                features={features}
            />
        </div>
    )
}