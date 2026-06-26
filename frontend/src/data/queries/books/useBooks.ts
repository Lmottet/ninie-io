import { bookApi } from '../../api/business/bookApi';
import { QueryKeys } from '../queryKeys';
import { queryOptions } from '@tanstack/react-query';

export const booksQueryOptions = queryOptions({
  queryKey: QueryKeys.books,
  queryFn: () => bookApi.fetch()
});
