import { api } from '../../libs/ky';
import type { CreateBookRequest } from '../../types/api/requests/CreateBookRequest';
import { BookSchema, type IBook } from './book';

export const bookApi = {
  fetch: async (): Promise<IBook[]> => {
    const response = await api.get('api/books').json();
    return BookSchema.array().parse(response);
  },

  get: async (id: number): Promise<IBook> => {
    const response = await api.get(`api/books/${id}`).json();
    return BookSchema.parse(response);
  },

  create: async (request: CreateBookRequest): Promise<IBook> => {
    const response = await api.post('api/books', { json: request }).json();
    return BookSchema.parse(response);
  },
};
