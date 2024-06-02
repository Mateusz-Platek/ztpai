'use client'

import {zodResolver} from "@hookform/resolvers/zod"
import {useForm} from "react-hook-form"
import {z} from "zod"

import { Button } from "@/components/ui/button"
import {
    Form,
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage,
} from "@/components/ui/form"
import { Input } from "@/components/ui/input"
import {Textarea} from "@/components/ui/textarea";
import {useRouter} from "next/navigation";
import {sendEmail} from "@/lib/actions/offer-actions";

const formSchema = z.object({
    title: z.string({
        required_error: "Title is required."
    }),
    text: z.string({
        required_error: "Text is required."
    })
})

export default function EmailForm({to, from}: {to: string, from: string}) {
    const form = useForm<z.infer<typeof formSchema>>({
        resolver: zodResolver(formSchema),
    })

    let router =  useRouter();

    async function onSubmit(values: z.infer<typeof formSchema>) {
        let emailData = {
            from: from,
            to: to,
            title: values.title,
            text: values.text
        }

        await sendEmail(emailData);

        router.back();
    }

    return (
        <Form {...form}>
            <form onSubmit={form.handleSubmit(onSubmit)} className="w-full md:w-96 flex flex-col gap-4 bg-secondary rounded p-6">
                <FormField
                    control={form.control}
                    name="title"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Title</FormLabel>
                            <FormControl>
                                <Input {...field} />
                            </FormControl>
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <FormField
                    control={form.control}
                    name="text"
                    render={({ field }) => (
                        <FormItem>
                            <FormLabel>Text</FormLabel>
                            <FormControl>
                                <Textarea
                                    className="resize-none"
                                    {...field}
                                />
                            </FormControl>
                            <FormMessage />
                        </FormItem>
                    )}
                />
                <Button type="submit">Submit</Button>
            </form>
        </Form>
    )
}