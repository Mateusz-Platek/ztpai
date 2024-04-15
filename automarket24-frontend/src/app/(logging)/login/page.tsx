import LoginForm from "@/components/login-form";
import Link from "next/link";

export default function Page() {
    return (
        <main className="flex flex-col items-center">
            <div className="font-bold text-4xl mb-6">Login</div>
            <LoginForm />
            <Link href={"/register"} className="underline mt-6">I don&apos;t have an account.</Link>
        </main>
    )
}