import OfferDetails from "@/components/offer-details";
import OfferMain from "@/components/offer-main";
import {getOffer} from "@/lib/actions";

export default async function Page({params}: {params: {id: number}}) {
    let offer: any = await getOffer(params.id)

    return (
        <div className="flex flex-col gap-6">
            <OfferMain offer={offer} />
            <OfferDetails description={offer.description} car={offer.car} />
        </div>
    );
}