import { api } from '../../libs/ky';
import { API_URL } from '../../utils/environment';
import { UserSchema, type IUser } from './user';
import ky from 'ky';

export const userApi = {
  tryGet: async (): Promise<IUser> => {
    const response = await ky.get(`${API_URL}/api/users/me`, { credentials: 'include' }).json();
    return UserSchema.parse(response);
  },

  get: async (): Promise<IUser> => {
    const response = await api.get('api/users/me').json();
    return UserSchema.parse(response);
  },
};
