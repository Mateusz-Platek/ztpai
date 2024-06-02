import AddOffer from "@/components/add-offer";
import {
    getBodyTypes,
    getColors,
    getConditions, getDamageTypes,
    getDrivetrains, getFeatures,
    getFuelTypes,
    getMakes,
    getTransmissions
} from "@/lib/actions/form-data-actions";
import {getUserData} from "@/lib/actions/security-actions";
import {redirect} from "next/navigation";

export default async function Page() {
    let userData = await getUserData();
    if (userData === null) {
        redirect("/login");
    }

    let makes = await getMakes();
    let colors = await getColors();
    let bodyTypes = await getBodyTypes();
    let drivetrains = await getDrivetrains();
    let transmissions = await getTransmissions();
    let fuelTypes = await getFuelTypes();
    let conditions = await getConditions();
    let damageTypes = await getDamageTypes();
    let features = await getFeatures();

    return (
        <div className="md:px-64">
            <div className="text-2xl md:text-3xl font-bold pb-4">Create an offer</div>
            <AddOffer
                makes={makes}
                colors={colors}
                bodyTypes={bodyTypes}
                drivetrains={drivetrains}
                transmissions={transmissions}
                fuelTypes={fuelTypes}
                conditions={conditions}
                damageTypes={damageTypes}
                features={features}
            />
        </div>
    )
}