import type { CreateSeriesRequest } from '../../../types/api/requests/CreateSeriesRequest';
import type { ISeries } from '../../../types/api/responses/ISeries';
import { authentifiedApi } from '../apiUtils';

export const seriesApi = {
  fetch: async () => await authentifiedApi.get<ISeries[]>(`/api/series`).json(),
  create: async (request: CreateSeriesRequest) => await authentifiedApi.post<ISeries>(`/api/series`, { json: request }).json()
};
