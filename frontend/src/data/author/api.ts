import { api } from '../../libs/ky';
import type { CreateAuthorRequest } from '../../types/api/requests/CreateAuthorRequest';
import { AuthorSchema, type IAuthor } from './author';

export const authorApi = {
  fetch: async (): Promise<IAuthor[]> => {
    const response = await api.get('api/authors').json();
    return AuthorSchema.array().parse(response);
  },

  create: async (request: CreateAuthorRequest): Promise<IAuthor> => {
    const response = await api.post('api/authors', { json: request }).json();
    return AuthorSchema.parse(response);
  },
};
