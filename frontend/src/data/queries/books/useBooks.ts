import { queryOptions } from '@tanstack/react-query';

import { bookApi } from '../../book/api';
import { BOOK_QUERY_KEYS } from '../../book/query-keys';

export const booksQueryOptions = queryOptions({
  queryKey: BOOK_QUERY_KEYS.books(),
  queryFn: () => bookApi.fetch(),
});
