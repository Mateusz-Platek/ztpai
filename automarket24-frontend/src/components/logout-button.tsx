'use client'

import {Button} from "@/components/ui/button";
import {useRouter} from "next/navigation";
import {removeToken} from "@/lib/actions/security-actions";

export default function LinkButton() {
    let router = useRouter();

    async function logout() {
        await removeToken();

        router.push("/home");

        router.refresh();
    }

    return (
        <Button onClick={() => logout()}>Logout</Button>
    );
}