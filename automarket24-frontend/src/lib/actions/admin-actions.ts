'use server'

import {cookies} from "next/headers";

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
