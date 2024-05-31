"use client"

import {TrashIcon} from "@radix-ui/react-icons";
import {Button} from "@/components/ui/button";
import {removeUser} from "@/lib/actions";
import {useRouter} from 'next/navigation'

interface User {
    id: number,
    email: string,
    phoneNumber: string,
    location: string,
    offers: Object[],
    observedOffers: Object[]
}

export default function AdminUser({ user }: { user: User }) {
    let router = useRouter();

    return (
        <div className="flex w-full bg-secondary shadow rounded h-28 justify-between items-center px-6">
            <div className="grid grid-cols-2">
                <div>Email:</div>
                <div>{user.email}</div>
                <div>Phone number:</div>
                <div>{user.phoneNumber}</div>
                {user.location != null && <div>Location:</div>}
                {user.location != null && <div>{user.location}</div>}
            </div>
            <Button variant="destructive" onClick={
                async () => {
                    let result = await removeUser(user.id);

                    if (result) {
                        router.refresh();
                    }
                }
            }>
                Remove <TrashIcon className="w-6 h-6"/>
            </Button>
        </div>
    )
}