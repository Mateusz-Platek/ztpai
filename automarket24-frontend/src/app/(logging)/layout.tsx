import React from "react";
import Header from '@/components/header';

export default function Layout({
    children
}: {
    children: React.ReactNode
}) {
    return (
        <>
            <Header logged={true} />
            <div className="my-10 md:px-8 w-full">
                {children}
            </div>
        </>
    );
}