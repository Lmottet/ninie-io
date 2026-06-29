import { redirect } from '@tanstack/react-router';

import { API_URL } from '../utils/environment';
import ky from 'ky';

export const api = ky.create({
  prefix: API_URL,
  credentials: 'include',
  timeout: 30_000,
  hooks: {
    afterResponse: [
      ({ response }) => {
        if (response.status === 401) {
          throw redirect({
            to: '/login',
            search: { redirect: location.href },
          });
        }
      },
    ],
  },
});
