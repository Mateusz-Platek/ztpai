"use server"

import { cookies } from 'next/headers'
import { redirect } from "next/navigation";

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
