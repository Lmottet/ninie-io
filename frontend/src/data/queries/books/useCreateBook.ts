import { useMutation, useQueryClient } from '@tanstack/react-query';

import type { CreateBookRequest } from '../../../types/api/requests/create-book-request';
import { bookApi } from '../../book/api';
import { BOOK_QUERY_KEYS } from '../../book/query-keys';

export function useCreateBook(onSuccess: () => void) {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (request: CreateBookRequest) => bookApi.create(request),
    onSuccess: () => {
      void queryClient.invalidateQueries({ queryKey: BOOK_QUERY_KEYS.books() });
      onSuccess();
    },
  });
}
