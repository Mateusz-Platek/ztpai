'use server'

import {cookies} from "next/headers";
import amqp from "amqplib/callback_api";

export async function getOffer(offerId: number) {
    let response = await fetch("http://localhost:8080/offers/" + offerId, {cache: "no-store"});
    return response.json();
}

export async function getOffers(searchParams: string) {
    let response = await fetch("http://localhost:8080/offers?" + searchParams, { cache: "no-store" });
    return response.json();
}

export async function getLatestOffers() {
    let response = await fetch("http://localhost:8080/offers/latest", {cache: "no-store"});
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