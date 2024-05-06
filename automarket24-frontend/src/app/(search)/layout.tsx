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
            <Header logged={false} />
            <div className="my-10 px-8 2xl:px-64">
                {children}
            </div>
        </>
    );
}