import { HeartIcon } from "@radix-ui/react-icons";

export default function SearchCar() {
    return (
        <div className="h-64 shadow-md rounded bg-secondary p-5 flex">
            <div className="w-1/4"></div>
            <div className="w-2/4 flex flex-col justify-between">
                <div className="font-bold text-2xl">Opel Insignia</div>
                <ul className="flex gap-4">
                    <li>150000 km</li>
                    <li>Diesel</li>
                    <li>Automatic</li>
                    <li>2015</li>
                    <li>140 KM</li>
                    <li>2000 cm3</li>
                </ul>
                <div>Warsaw</div>
                <div>Published 2024-03-05</div>
            </div>
            <div className="w-1/4 flex flex-col justify-between items-end">
                <div className="font-bold text-2xl">50000 PLN</div>
                <HeartIcon className="h-6 w-6"/>
            </div>
        </div>
    );
}