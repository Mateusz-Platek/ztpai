'use server'

import {cookies} from 'next/headers'
import * as jose from 'jose'
import amqp from "amqplib/callback_api";

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

export async function getOffer(offerId: number) {
    let response = await fetch("http://localhost:8080/offers/" + offerId, {cache: "no-store"});
    return response.json();
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

export async function sendEmail(emailData: any) {
    amqp.connect('amqp://user:password@localhost:6030', function(error0, connection) {
        if (error0) {
            throw error0;
        }

        connection.createConfirmChannel(function (error1, channel) {
            if (error1) {
                throw error1;
            }

            channel.assertQueue("email", {
                durable: false
            });

            channel.sendToQueue("email", Buffer.from(JSON.stringify(emailData)), {
                contentType: "application/json",
                headers: {
                    "__TypeId__": "org.example.automarket24backend.email.EmailDto"
                }
            }, function (err, ok) {
                if (err != null) {
                    connection.close();
                }
            });
        });
    });
}

export async function getLatestOffers() {
    let response = await fetch("http://localhost:8080/offers/latest", {cache: "no-store"});
    return response.json();
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

export async function getOffers(searchParams: string) {
    let response = await fetch("http://localhost:8080/offers?" + searchParams, { cache: "no-store" });
    return response.json();
}
