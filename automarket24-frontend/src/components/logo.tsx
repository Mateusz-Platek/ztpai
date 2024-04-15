import Link from "next/link";

export default function Logo() {
    return (
        <Link href={"/home"} className="w-72 h-14 bg-primary text-primary-foreground flex justify-center items-center rounded font-bold text-3xl">
            AutoMarket24
        </Link>
    );
}