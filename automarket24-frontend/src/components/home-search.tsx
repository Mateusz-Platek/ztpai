'use client';

import {zodResolver} from "@hookform/resolvers/zod"
import {useForm} from "react-hook-form"
import {z} from "zod"

import {Button} from "@/components/ui/button"
import {Form, FormControl, FormField, FormItem, FormLabel} from "@/components/ui/form"
import {Input} from "@/components/ui/input"
import {Select, SelectContent, SelectItem, SelectTrigger, SelectValue} from "@/components/ui/select";
import {MagnifyingGlassIcon, MixerHorizontalIcon} from "@radix-ui/react-icons";
import Link from "next/link";
import {useRouter} from "next/navigation";

const formSchema = z.object({
    make: z.string().optional(),
    model: z.string().optional(),
    priceFrom: z.coerce.number().optional(),
    priceTo: z.coerce.number().optional(),
    mileageFrom: z.coerce.number().optional(),
    mileageTo: z.coerce.number().optional()
})

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

export default function HomeSearch({
    makes
}: {
    makes: any
}) {
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema)
    })

    let router = useRouter();

    function onSubmit(values: z.infer<typeof formSchema>) {
        let params = addParams(values);

        router.push("/search?" + params);

        router.refresh();
    }

    let make = makes.find((make: any) => make.id == form.watch("make"));
    let models = make != undefined ? make.models : undefined;

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="shadow-md p-6 rounded grid grid-cols-4 gap-4 bg-secondary">
                <FormField
                    control={form.control}
                    name="make"
                    render={({ field }) => (
                        <FormItem className="col-span-2">
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
                        <FormItem className="col-span-2">
                            <FormLabel>Model</FormLabel>
                            <Select onValueChange={field.onChange} defaultValue={field.value} disabled={models == undefined}>
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
                    name="priceFrom"
                    render={({field}) => (
                        <FormItem>
                            <FormLabel>Price from</FormLabel>
                            <FormControl>
                                <Input type="number" {...field} />
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
                                <Input type="number" {...field} />
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
                                <Input type="number" {...field} />
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
                                <Input type="number" {...field} />
                            </FormControl>
                        </FormItem>
                    )}
                />
                <Link href={"/search"} className="underline flex items-center gap-4">Advanced search <MixerHorizontalIcon className="w-6 h-6" /></Link>
                <Button type="submit" className="col-end-5 flex gap-1">Search<MagnifyingGlassIcon className="h-6 w-6" /></Button>
            </form>
        </Form>
    );
}