import type { LoginRequest } from '../../../types/api/requests/LoginRequest';
import ky from 'ky';
import { API_URL } from '../apiUtils';
import type { IUserSession } from '../../../types/api/responses/IUserSession';

export const loginApi = {
  login: async (request: LoginRequest) => await ky.post<IUserSession>(`${API_URL}/auth/login`, { json: request }).json()
};
