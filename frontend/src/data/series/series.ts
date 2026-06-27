import { z } from 'zod';

export const SeriesSchema = z
  .object({
    id: z.string(),
    title: z.string(),
    isFinished: z.boolean(),
  })
  .strict();

export type ISeries = z.infer<typeof SeriesSchema>;
