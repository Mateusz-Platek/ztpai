export default function HomeCar() {
    return (
        <div className="bg-secondary rounded w-96 h-96 shadow-md">
            <div className="h-3/5">

            </div>
            <div className="p-3 text-secondary-foreground h-2/5 flex flex-col justify-between">
                <div className="font-bold text-xl">Opel Insignia</div>
                <ul className="flex justify-between">
                    <li>2014</li>
                    <li>140 KM</li>
                    <li>2000 cm3</li>
                    <li>Diesel</li>
                    <li>250000 km</li>
                </ul>
                <div className="font-bold text-2xl">50000 PLN</div>
            </div>
        </div>
    );
}