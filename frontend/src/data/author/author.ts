import { z } from 'zod';

export const AuthorSchema = z
  .object({
    id: z.string(),
    firstName: z.string(),
    lastName: z.string(),
  })
  .strict();

export type IAuthor = z.infer<typeof AuthorSchema>;
