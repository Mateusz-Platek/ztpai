import AdminUser from "@/components/admin-user";
import {getUsers} from "@/lib/actions/admin-actions";
import {getUserData} from "@/lib/actions/security-actions";

export default async function Page() {
    let data = await getUsers();
    let currentUser = await getUserData();

    data = data.filter((user: any) => (user.id !== currentUser?.id));

    return (
        <>
            <div className="pb-4 text-2xl md:text-3xl font-bold">Manage users</div>
            <div className="flex flex-col gap-4">
                {data.map((user: any) => (<AdminUser key={user.id} user={user}/>))}
            </div>
        </>
    )
}