import { api } from '../../libs/ky';
import type { CreateSeriesRequest } from '../../types/api/requests/CreateSeriesRequest';
import { SeriesSchema, type ISeries } from './series';

export const seriesApi = {
  fetch: async (): Promise<ISeries[]> => {
    const response = await api.get('api/series').json();
    return SeriesSchema.array().parse(response);
  },

  create: async (request: CreateSeriesRequest): Promise<ISeries> => {
    const response = await api.post('api/series', { json: request }).json();
    return SeriesSchema.parse(response);
  },
};
