import Logo from "@/components/logo";
import LinkButton from "@/components/link-button";
import {ModeToggle} from "@/components/mode-toggle";
import {getUserData} from "@/lib/actions";
import LogoutButton from "@/components/logout-button";

export default async function Header({
    logged
}: {
    logged: boolean
}) {
    let data = await getUserData();

    let buttons = <nav className="flex items-center gap-4">
        <LinkButton text="Login" path="/login"/>
        <LinkButton text="Register" path="/register"/>
        <ModeToggle/>
    </nav>;

    if (data != null) {
        if (data.role == "Admin") {
            buttons = <nav className="flex items-center gap-4">
                <LinkButton text="Manage users" path="/admin"/>
                <LinkButton text="Add offer" path="/add"/>
                <LogoutButton />
                <ModeToggle/>
            </nav>;
        } else {
            buttons = <nav className="flex items-center gap-4">
                <LinkButton text="Add offer" path="/add"/>
                <LogoutButton />
                <ModeToggle/>
            </nav>;
        }
    }

    if (logged) {
        buttons = <nav className="flex items-center">
            <ModeToggle/>
        </nav>;
    }

    return (
        <header className="w-full h-24 px-8 2xl:px-64 flex justify-between shadow-md">
            <div className="flex justify-items-center items-center">
                <Logo/>
            </div>
            { buttons }
        </header>
    );
}