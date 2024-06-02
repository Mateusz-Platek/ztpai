import Car from "@/lib/interfaces/car";

export default interface SearchOffer {
    id: number;
    price: number;
    postTime: Date;
    location: string;
    car: Car;
}