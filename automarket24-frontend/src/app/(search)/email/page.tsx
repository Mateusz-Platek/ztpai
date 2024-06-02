import EmailForm from "@/components/email-form";
import {redirect} from "next/navigation";
import {getUserData} from "@/lib/actions/security-actions";

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
        <div className="flex flex-col items-center">
            <div className="text-2xl font-bold pb-8">Email to: {to}</div>
            <EmailForm to={to} from={from}/>
        </div>
    )
}