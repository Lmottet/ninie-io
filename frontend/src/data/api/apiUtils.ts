import ky from 'ky';

export const API_URL = 'https://localhost:10000';

export const authentifiedApi = ky.create({
  prefixUrl: API_URL,
  credentials: 'include',
  headers: {
    'Content-Type': 'application/json'
  }
});
