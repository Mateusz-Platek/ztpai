import {Button} from "@/components/ui/button";
import React from "react";
import Link from "next/link";

export default function LinkButton({
    text, path
}: {
    text: string, path: string
}) {
    return (
        <Button asChild className="w-32">
            <Link href={path}>{text}</Link>
        </Button>
    );
}