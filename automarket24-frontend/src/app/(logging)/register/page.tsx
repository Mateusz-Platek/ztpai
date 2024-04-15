import RegisterForm from "@/components/register-form";
import Link from "next/link";

export default function Page() {
    return (
        <main className="flex flex-col items-center">
            <div className="font-bold text-4xl mb-6">Register</div>
            <RegisterForm />
            <Link href={"/login"} className="underline mt-6">I have an account.</Link>
        </main>
    )
}