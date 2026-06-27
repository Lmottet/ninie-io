import { useMutation, useQueryClient } from '@tanstack/react-query';

import type { CreateAuthorRequest } from '../../../types/api/requests/CreateAuthorRequest';
import { authorApi } from '../../author/api';
import { AUTHOR_QUERY_KEYS } from '../../author/query-keys';

export function useCreateAuthor(onSuccess: () => void) {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (request: CreateAuthorRequest) => authorApi.create(request),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: AUTHOR_QUERY_KEYS.authors() });
      onSuccess();
    },
  });
}
