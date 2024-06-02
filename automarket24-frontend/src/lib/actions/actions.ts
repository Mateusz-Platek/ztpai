'use server'

import {cookies} from 'next/headers'
import * as jose from 'jose'

export async function login(userData: any) {
    let response = await fetch("http://localhost:8080/login", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
    });

    let data = await response.json();

    cookies().set({
        name: "token",
        value: data.jwt,
        httpOnly: true
    });
}

export async function register(userData: any) {
    let response = await fetch("http://localhost:8080/register", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
    });

    let data = await response.json();

    cookies().set({
        name: "token",
        value: data.jwt,
        httpOnly: true
    });
}

export async function removeToken() {
    if (cookies().has("token")) {
        cookies().delete("token");
    }
}

export async function getUserData() {
    let jwt = cookies().get("token");

    if (jwt == undefined) {
        return null;
    }

    let payload = jose.decodeJwt(jwt.value);

    if (payload.sub == undefined) {
        return null;
    }

    let id = payload.id as number;
    let email = payload.sub;
    let role = payload.role as string;

    return { id, email, role };
}

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
