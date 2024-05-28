'use client';

import { z } from "zod";
import { useForm } from "react-hook-form";
import { zodResolver } from "@hookform/resolvers/zod";

import {
    Form,
    FormControl,
    FormField,
    FormItem,
    FormLabel
} from "@/components/ui/form";
import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue
} from "@/components/ui/select";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";
import { MagnifyingGlassIcon } from "@radix-ui/react-icons";
import { useRouter } from "next/navigation";

const formSchema = z.object({
    make: z.string().optional(),
    model: z.string().optional(),
    generation: z.string().optional(),
    priceFrom: z.coerce.number().optional(),
    priceTo: z.coerce.number().optional(),
    mileageFrom: z.coerce.number().optional(),
    mileageTo: z.coerce.number().optional(),
    powerFrom: z.coerce.number().optional(),
    powerTo: z.coerce.number().optional(),
    engineSizeFrom: z.coerce.number().optional(),
    engineSizeTo: z.coerce.number().optional(),
    productionYearFrom: z.coerce.number().optional(),
    productionYearTo: z.coerce.number().optional(),
    bodyType: z.string().optional(),
    color: z.string().optional(),
    drivetrain: z.string().optional(),
    damageType: z.string().optional(),
    transmission: z.string().optional(),
    fuelType: z.string().optional(),
    location: z.string().optional(),
    condition: z.string().optional()
})

export default function CoreSearch({
    makes, colors, bodyTypes, drivetrains, transmissions, fuelTypes, conditions, damageTypes
}: {
    makes: any, colors: any, bodyTypes: any, drivetrains: any, transmissions: any, fuelTypes: any, conditions: any, damageTypes: any
}) {
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema)
    })

    let router = useRouter();

    function addParams(values: z.infer<typeof formSchema>) {
        let urlSearchParams = new URLSearchParams();

        Object.entries(values).forEach(([key, value]) => {
            if (value != undefined) {
                urlSearchParams.append(key.toString(), value.toString());
            } else {
                if (urlSearchParams.has(key)) {
                    urlSearchParams.delete(key);
                }
            }
        });

        return urlSearchParams.toString();
    }

    function onSubmit(values: z.infer<typeof formSchema>) {
        let params = addParams(values);

        router.push("/search?" + params);

        router.refresh();
    }

    let make = makes.find((make: any) => make.id == form.watch("make"));
    let models = make != undefined ? make.models : undefined;
    let model = undefined;
    if (models != undefined) {
        model = models.find((model: any) => model.id == form.watch("model"));
    }
    let generations = model != undefined ? model.generations : undefined;

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="shadow-md p-6 rounded grid grid-cols-6 gap-4 bg-secondary">
                <FormField
                    control={form.control}
                    name="make"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Make</FormLabel>
                            <Select onValueChange={(value) => {
                                field.onChange(value);
                                form.setValue("model", undefined);
                                form.setValue("generation", undefined);
                            }} defaultValue={field.value}>
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
                            <Select onValueChange={field.onChange} defaultValue={field.value} disabled={generations == undefined || generations.length == 0}>
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
                    name="priceFrom"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Price from</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="priceTo"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Price to</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="mileageFrom"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Mileage from</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="mileageTo"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Mileage to</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="powerFrom"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Power from</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="powerTo"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Power to</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="engineSizeFrom"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Engine size from</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="engineSizeTo"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Engine size to</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="productionYearFrom"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Production year from</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="productionYearTo"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Production year to</FormLabel>
                            <FormControl>
                                <Input {...field} />
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
                                        (conditions: any) => (<SelectItem key={conditions.id} value={conditions.id.toString()}>{conditions.name}</SelectItem>)
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
                    name="location"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Location</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <Button type="submit" className="col-end-7 flex gap-1 self-end">Search<MagnifyingGlassIcon className="h-6 w-6" /></Button>
            </form>
        </Form>
    );
}