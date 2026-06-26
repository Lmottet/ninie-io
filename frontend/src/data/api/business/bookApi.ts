import type { CreateBookRequest } from '../../../types/api/requests/CreateBookRequest';
import type { IBook } from '../../../types/api/responses/IBook';
import { authentifiedApi } from '../apiUtils';

export const bookApi = {
  fetch: async () => await authentifiedApi.get<IBook[]>(`/api/books`).json(),
  get: async (id: number) => await authentifiedApi.get<IBook>(`/api/books/${id}`).json(),

  create: async (request: CreateBookRequest) => await authentifiedApi.post<IBook>(`/api/books`, { json: request }).json()
};
