import { useMutation } from '@tanstack/react-query';

import { authApi } from '../../auth/auth-api';

export function useLogout({ onSuccess }: { onSuccess?: () => void } = {}) {
  return useMutation({
    mutationFn: () => authApi.logout(),
    onSuccess,
  });
}
