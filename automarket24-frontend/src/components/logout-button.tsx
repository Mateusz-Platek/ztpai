'use client'

import { logout } from "@/lib/actions";
import { Button } from "@/components/ui/button";

export default function LinkButton() {
    return (
        <Button onClick={() => logout()}>Logout</Button>
    );
}