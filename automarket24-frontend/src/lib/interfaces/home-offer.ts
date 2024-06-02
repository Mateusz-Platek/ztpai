import Car from "@/lib/interfaces/car";

export default interface HomeOffer {
    id: number;
    price: number;
    postTime: Date;
    location: string;
    car: Car;
}