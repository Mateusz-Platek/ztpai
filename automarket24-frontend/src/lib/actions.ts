'use server'

import { cookies } from 'next/headers'
import { redirect } from "next/navigation";
import * as jose from 'jose'

export async function login(userData: {email: string, password: string}) {
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

    redirect("/home")
}

export async function register(userData: {email: string, password: string, phoneNumber: string, location: string}) {
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

    redirect("/home")
}

export async function logout() {
    if (cookies().has("token")) {
        cookies().delete("token");
    }

    redirect("/home");
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

export async function getUsers() {
    let jwt = cookies().get("token")?.value;

    let response = await fetch("http://localhost:8080/users", {
        headers: {
            "Authorization": "Bearer " + jwt
        }
    });

    return response.json();
}

export async function removeUser(userId: number) {
    let jwt = cookies().get("token")?.value;

    let response = await fetch("http://localhost:8080/users/" + userId, {
        method: "DELETE",
        headers: {
            "Authorization": "Bearer " + jwt
        },
        cache: "no-store"
    });

    return response.ok;
}

export async function addOffer(data: FormData) {
    let jwt = cookies().get("token")?.value;

    let response = await fetch("http://localhost:8080/offers", {
        method: "POST",
        headers: {
            "Authorization": "Bearer " + jwt
        },
        body: data
    });

    return response.ok;
}
