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
            <div className="mt-12 px-8 2xl:px-64">
                {children}
            </div>
        </>
    );
}