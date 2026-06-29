import { z } from 'zod';

export const BookSchema = z
  .object({
    id: z.string(),
    title: z.string(),
    tome: z.number(),
  })
  .strict();

export type IBook = z.infer<typeof BookSchema>;
