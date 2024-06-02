'use client'

import {TrashIcon} from "@radix-ui/react-icons";
import {Button} from "@/components/ui/button";
import {removeUser} from "@/lib/actions";
import {useRouter} from 'next/navigation'
import FullUser from "@/lib/interfaces/full-user";

export default function AdminUser({ user }: { user: FullUser }) {
    let router = useRouter();

    return (
        <div className="w-full flex flex-col md:flex-row gap-2 bg-secondary shadow-md rounded justify-between items-center px-6 py-4">
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