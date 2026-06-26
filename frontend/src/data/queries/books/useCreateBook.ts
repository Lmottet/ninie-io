import type { CreateBookRequest } from '../../../types/api/requests/CreateBookRequest';
import { bookApi } from '../../api/business/bookApi';
import { QueryKeys } from '../queryKeys';
import { useMutation, useQueryClient } from '@tanstack/react-query';

export function useCreateBook(onSuccess: () => void) {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (request: CreateBookRequest) => bookApi.create(request),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: QueryKeys.books });
      onSuccess();
    }
  });
}
