'use server'

import {cookies} from "next/headers";
import * as jose from "jose";

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

    return {id, email, role};
}