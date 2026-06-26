import { queryOptions, useQuery } from '@tanstack/react-query';
import { authorApi } from '../../api/business/authorApi';
import { QueryKeys } from '../queryKeys';

export const authorsQueryOptions = queryOptions({
  queryKey: QueryKeys.authors,
  queryFn: () => authorApi.fetch()
});

export function useAuthors() {
  return useQuery(authorsQueryOptions);
}
