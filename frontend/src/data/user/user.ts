import { z } from 'zod';

export const UserSchema = z
  .object({
    firstName: z.string(),
    lastName: z.string(),
  })
  .strict();

export type IUser = z.infer<typeof UserSchema>;
