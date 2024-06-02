'use client';

import Link from "next/link";
import {Button} from "@/components/ui/button";
import React from "react";
import {EnvelopeClosedIcon} from "@radix-ui/react-icons";

export default function EmailButton({path}: {path: string}) {
    return (
        <Button asChild className="flex items-center gap-2">
            <Link href={path}><EnvelopeClosedIcon className="w-6 h-6"/> Send email</Link>
        </Button>
    )
}