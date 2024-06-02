import EmailForm from "@/components/email-form";
import {getUserData} from "@/lib/actions";
import {redirect} from "next/navigation";

export default async function Page({
    searchParams
}: {
    searchParams: { [key: string]: string | string[] | undefined }
}) {
    let userData = await getUserData();
    if (userData === null) {
        redirect("/login")
    }

    let from = userData.email;
    let to = searchParams.email as string;

    return (
        <div>
            <div>Email</div>
            <EmailForm to={to} from={from}/>
        </div>
    )
}