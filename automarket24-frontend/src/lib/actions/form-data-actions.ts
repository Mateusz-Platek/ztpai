'use server'

export async function getMakes() {
    let response = await fetch("http://localhost:8080/makes", {cache: "no-store"});
    return response.json();
}

export async function getColors() {
    let response = await fetch("http://localhost:8080/colors", { cache: "no-store" });
    return response.json();
}

export async function getBodyTypes() {
    let response = await fetch("http://localhost:8080/body-types", { cache: "no-store" });
    return response.json();
}

export async function getDrivetrains() {
    let response = await fetch("http://localhost:8080/drivetrains", { cache: "no-store" });
    return response.json();
}

export async function getTransmissions() {
    let response = await fetch("http://localhost:8080/transmissions", { cache: "no-store" });
    return response.json();
}

export async function getFuelTypes() {
    let response = await fetch("http://localhost:8080/fuel-types", { cache: "no-store" });
    return response.json();
}

export async function getConditions() {
    let response = await fetch("http://localhost:8080/conditions", { cache: "no-store" });
    return response.json();
}

export async function getDamageTypes() {
    let response = await fetch("http://localhost:8080/damage-types", { cache: "no-store" });
    return response.json();
}

export async function getFeatures() {
    let response = await fetch("http://localhost:8080/features", { cache: "no-store" });
    return response.json();
}
