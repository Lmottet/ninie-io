import type { CreateAuthorRequest } from '../../../types/api/requests/CreateAuthorRequest';
import type { IAuthor } from '../../../types/api/responses/IAuthor';
import { authentifiedApi } from '../apiUtils';

export const authorApi = {
  fetch: async () => await authentifiedApi.get<IAuthor[]>(`/api/authors`).json(),
  create: async (request: CreateAuthorRequest) => await authentifiedApi.post<IAuthor>(`/api/authors`, { json: request, credentials: 'include' }).json()
};
