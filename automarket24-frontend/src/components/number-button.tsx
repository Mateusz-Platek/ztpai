'use client'

import {Button} from "@/components/ui/button";
import {useState} from "react";
import {PhoneIcon} from "lucide-react";

export default function NumberButton({phoneNumber}: {phoneNumber: string}) {
    const [text, setText] = useState("Show number");

    function handleClick() {
        setText(phoneNumber);
    }
    
    return (
        <Button onClick={handleClick} className="flex gap-2"><PhoneIcon className="w-6 h-6"/> {text}</Button>
    )
}