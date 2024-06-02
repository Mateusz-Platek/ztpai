export default interface FullUser {
    id: number,
    email: string,
    phoneNumber: string,
    location: string,
    offers: Object[],
    observedOffers: Object[]
}