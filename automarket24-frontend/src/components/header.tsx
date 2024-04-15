import Logo from "@/components/logo";
import LinkButton from "@/components/link-button";
import { ModeToggle } from "@/components/mode-toggle";

export default function Header({
    logged
}: {
    logged: boolean
}) {
    let buttons = <nav className="flex items-center gap-4">
        <LinkButton text="Login" path="/login"/>
        <LinkButton text="Register" path="/register"/>
        <ModeToggle/>
    </nav>;

    if (logged) {
        buttons = <nav className="flex items-center">
            <ModeToggle/>
        </nav>;
    }

    return (
        <header className="w-full h-24 px-64 flex justify-between shadow-md">
            <div className="flex justify-items-center items-center">
                <Logo/>
            </div>
            { buttons }
        </header>
    );
}