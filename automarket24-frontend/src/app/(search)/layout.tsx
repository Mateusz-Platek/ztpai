import React from "react";
import Header from '@/components/header';

export default async function Layout({
    children
}: {
    children: React.ReactNode
}) {
    return (
        <>
            <Header logged={false} />
            <div className="my-10 px-8 2xl:px-64">
                {children}
            </div>
        </>
    );
}