import React from "react";
import Header from '@/components/header';
import Footer from '@/components/footer';

export default function Layout({
    children
}: {
    children: React.ReactNode
}) {
    return (
        <>
            <Header logged={true} />
            <div className="my-10 px-8 2xl:px-6 w-full">
                {children}
            </div>
        </>
    );
}