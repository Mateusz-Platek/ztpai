import {getUserData, getUsers} from "@/lib/actions";
import AdminUser from "@/components/admin-user";

interface User {
    id: number,
    email: string,
    phoneNumber: string,
    location: string,
    offers: Object[],
    observedOffers: Object[]
}

export default async function Page() {
    let data: User[] = await getUsers();
    let currentUser = await getUserData();

    data = data.filter((user) => (user.id !== currentUser?.id));

    return (
        <div className="flex flex-col gap-4">
            {data.map((user) => (<AdminUser key={user.id} user={user}/>))}
        </div>
    )
}