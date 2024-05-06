import type {Metadata} from "next";
import {Inter} from "next/font/google";
import "../styles/globals.css";
import {ThemeProvider} from "@/components/theme-provider";
import Footer from "@/components/footer";

const inter = Inter({subsets: ["latin"]});

export const metadata: Metadata = {
    title: "AutoMarket24",
    description: "Modern car marketplace.",
};

export default function RootLayout({
   children,
}: Readonly<{
    children: React.ReactNode;
}>) {
    return (
        <html lang="en">
        <body className={inter.className}>
        <ThemeProvider
            attribute="class"
            defaultTheme="system"
            enableSystem
            disableTransitionOnChange
        >
            <div className="min-h-screen flex flex-col justify-between">
                <div>
                    {children}
                </div>
                <Footer />
            </div>
        </ThemeProvider>
        </body>
        </html>
    );
}
