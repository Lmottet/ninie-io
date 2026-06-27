import { queryOptions, useQuery } from '@tanstack/react-query';

import { authorApi } from '../../author/api';
import { AUTHOR_QUERY_KEYS } from '../../author/query-keys';

export const authorsQueryOptions = queryOptions({
  queryKey: AUTHOR_QUERY_KEYS.authors(),
  queryFn: () => authorApi.fetch(),
});

export function useAuthors() {
  return useQuery(authorsQueryOptions);
}
