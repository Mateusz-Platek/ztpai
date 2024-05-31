'use client'

import {z} from "zod";
import {useForm} from "react-hook-form";
import {zodResolver} from "@hookform/resolvers/zod";

import {Button} from "@/components/ui/button"
import {Form, FormControl, FormField, FormItem, FormLabel} from "@/components/ui/form"
import {Input} from "@/components/ui/input"
import {Textarea} from "@/components/ui/textarea";
import {Select, SelectContent, SelectItem, SelectTrigger, SelectValue} from "@/components/ui/select";
import {Checkbox} from "@/components/ui/checkbox";
import {addOffer, getUserData} from "@/lib/actions";
import {useRouter} from "next/navigation";

const formSchema = z.object({
    images: z.any(),
    make: z.string(),
    model: z.string().optional(),
    generation: z.string().optional(),
    price: z.coerce.number(),
    mileage: z.coerce.number(),
    power: z.coerce.number(),
    engineSize: z.coerce.number(),
    productionYear: z.coerce.number(),
    seats: z.coerce.number(),
    doors: z.coerce.number(),
    bodyType: z.string(),
    color: z.string(),
    drivetrain: z.string(),
    damageType: z.string(),
    transmission: z.string(),
    fuelType: z.string(),
    location: z.string(),
    condition: z.string(),
    features: z.string().array().refine((value) => value.some((item) => item)),
    description: z.string()
})

export default function AddOffer({
    makes, colors, bodyTypes, drivetrains, transmissions, fuelTypes, conditions, damageTypes, features
}: {
    makes: any, colors: any, bodyTypes: any, drivetrains: any, transmissions: any, fuelTypes: any, conditions: any, damageTypes: any, features: any
}) {
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema)
    })

    const router = useRouter();

    async function onSubmit(values: z.infer<typeof formSchema>) {
        let formData = new FormData();

        for (let i = 0; i < values.images.length; i++) {
            formData.append("images", values.images[i]);
        }

        let userData = await getUserData();

        let offer = {
            description: values.description,
            price: values.price,
            userId: userData?.id,
            car: {
                productionYear: values.productionYear,
                mileage: values.mileage,
                power: values.power,
                engineSize: values.engineSize,
                seats: values.seats,
                doors: values.doors,
                make: values.make,
                model: values.model,
                generation: values.generation,
                bodyType: values.bodyType,
                transmission: values.transmission,
                drivetrain: values.drivetrain,
                color: values.color,
                fuelType: values.fuelType,
                damageType: values.damageType,
                condition: values.condition,
                features: values.features
            }
        };

        formData.append("offerDto", new Blob([JSON.stringify(offer)], {
            type: 'application/json'
        }));

        await addOffer(formData);
    }

    let make = makes.find((make: any) => make.id == form.watch("make"));
    let models = make != undefined ? make.models : undefined;
    let model = undefined;
    if (models != undefined) {
        model = models.find((model: any) => model.id == form.watch("model"));
    }
    let generations = model != undefined ? model.generations : undefined;

    let featuresStr = features.map((feature: any) => ({
        id: feature.id.toString(),
        name: feature.name
    }));

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="grid grid-cols-1 md:grid-cols-2 gap-6">
                <FormField
                    control={form.control}
                    name="make"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Make</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {makes.map(
                                        (make: any) => (<SelectItem key={make.id} value={make.id.toString()}>{make.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="model"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Model</FormLabel>
                            <Select onValueChange={(value) => {
                                field.onChange(value);
                                form.setValue("generation", undefined);
                            }} defaultValue={field.value} disabled={models == undefined}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {models != undefined && models.map(
                                        (model: any) => (<SelectItem key={model.id} value={model.id.toString()}>{model.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="generation"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Generation</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}
                                    disabled={generations == undefined || generations.length == 0}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {generations != undefined && generations.map(
                                        (generation: any) => (<SelectItem key={generation.id} value={generation.id.toString()}>{generation.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="price"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Price</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="mileage"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Mileage</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="power"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Power</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="engineSize"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Engine size</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="productionYear"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Production year</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="doors"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Doors</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="seats"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Seats</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="bodyType"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Body type</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {bodyTypes.map(
                                        (bodyType: any) => (<SelectItem key={bodyType.id} value={bodyType.id.toString()}>{bodyType.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="color"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Color</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {colors.map(
                                        (color: any) => (<SelectItem key={color.id} value={color.id.toString()}>{color.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="drivetrain"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Drivetrain</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {drivetrains.map(
                                        (drivetrain: any) => (<SelectItem key={drivetrain.id} value={drivetrain.id.toString()}>{drivetrain.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="damageType"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Damage type</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {damageTypes.map(
                                        (damageType: any) => (<SelectItem key={damageType.id} value={damageType.id.toString()}>{damageType.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="transmission"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Transmission</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {transmissions.map(
                                        (transmission: any) => (<SelectItem key={transmission.id} value={transmission.id.toString()}>{transmission.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="fuelType"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Fuel type</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {fuelTypes.map(
                                        (fuelType: any) => (<SelectItem key={fuelType.id} value={fuelType.id.toString()}>{fuelType.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="location"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Location</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="condition"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Condition</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value}>
                                <FormControl>
                                    <SelectTrigger>
                                        <SelectValue />
                                    </SelectTrigger>
                                </FormControl>
                                <SelectContent>
                                    {conditions.map(
                                        (condition: any) => (<SelectItem key={condition.id} value={condition.id.toString()}>{condition.name}</SelectItem>)
                                    )}
                                </SelectContent>
                            </Select>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="features"
                    render={() => (
                        <FormItem className="col-start-1 md:col-end-3">
                            <FormLabel>Features</FormLabel>
                            <div className="grid grid-cols-1 md:grid-cols-2 gap-2">
                                {featuresStr.map((feature: any) => (
                                    <FormField
                                        key={feature.id}
                                        control={form.control}
                                        name="features"
                                        render={({ field }) => {
                                            return (
                                                <FormItem key={feature.id} className="flex flex-row items-start space-x-3 space-y-0">
                                                    <FormControl>
                                                        <Checkbox
                                                            checked={field.value?.includes(feature.id)}
                                                            onCheckedChange={(checked) => {
                                                                field.value = field.value || [];
                                                                return checked ? field.onChange([...field.value, feature.id]) : field.onChange(
                                                                    field.value?.filter(
                                                                        (value) => value !== feature.id
                                                                    )
                                                                )
                                                            }}
                                                        />
                                                    </FormControl>
                                                    <FormLabel className="font-normal">
                                                        {feature.name}
                                                    </FormLabel>
                                                </FormItem>
                                            )
                                        }}
                                    />
                                ))}
                            </div>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="images"
                    render={({ field }) => (
                        <FormItem className="col-start-1 md:col-end-3">
                            <FormLabel>Images</FormLabel>
                            <FormControl>
                                <Input type="file" accept="image/*" multiple {...form.register("images")} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="description"
                    render={({ field }) => (
                        <FormItem className="col-start-1 md:col-end-3">
                            <FormLabel>Description</FormLabel>
                            <FormControl>
                                <Textarea className="resize-none h-32" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <Button type="submit" className="col-start-1 md:col-end-3" >Submit</Button>
            </form>
        </Form>
    )
}
