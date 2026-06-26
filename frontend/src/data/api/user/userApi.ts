import type { IUserSession } from '../../../types/api/responses/IUserSession';
import { authentifiedApi } from '../apiUtils';

export const userApi = {
  info: async () => await authentifiedApi.get<IUserSession>(`/api/users/me`).json()
};
