import type { LoginRequest } from '../../types/api/requests/LoginRequest';
import { API_URL } from '../../utils/environment';
import ky from 'ky';

export const authApi = {
  login: async (request: LoginRequest): Promise<void> => {
    await ky.post(`${API_URL}/auth/login`, { json: request, credentials: 'include' });
  },
};
