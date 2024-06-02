import Car from "@/lib/interfaces/car";
import User from "@/lib/interfaces/user";

export default interface Offer {
    id: number,
    postTime: string,
    description: string,
    price: number,
    user: User
    car: Car
}