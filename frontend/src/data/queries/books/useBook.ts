import { queryOptions, useQuery } from '@tanstack/react-query';

import { bookApi } from '../../book/api';
import { BOOK_QUERY_KEYS } from '../../book/query-keys';

export const bookQueryOptions = (bookId: number) =>
  queryOptions({
    queryKey: BOOK_QUERY_KEYS.book(bookId),
    queryFn: () => bookApi.get(bookId),
  });

export function useBook(bookId: number) {
  return useQuery(bookQueryOptions(bookId));
}
