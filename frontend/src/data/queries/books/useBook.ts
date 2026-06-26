import { bookApi } from '../../api/business/bookApi';
import { QueryKeys } from '../queryKeys';
import { queryOptions, useQuery } from '@tanstack/react-query';

export const bookQueryOptions = (bookId: number) =>
  queryOptions({
    queryKey: QueryKeys.book(bookId),
    queryFn: () => bookApi.get(bookId)
  });

export function useBook(bookId: number) {
  return useQuery(bookQueryOptions(bookId));
}
