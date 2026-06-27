import { useMutation } from '@tanstack/react-query';

import type { LoginRequest } from '../../../types/api/requests/LoginRequest';
import { authApi } from '../../auth/auth-api';

export function useLogin({ onSuccess }: { onSuccess?: () => void } = {}) {
  return useMutation({
    mutationFn: (request: LoginRequest) => authApi.login(request),
    onSuccess,
  });
}
