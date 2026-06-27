import { queryOptions, useQuery } from '@tanstack/react-query';

import { seriesApi } from '../../series/api';
import { SERIES_QUERY_KEYS } from '../../series/query-keys';

export const seriesQueryOptions = queryOptions({
  queryKey: SERIES_QUERY_KEYS.series(),
  queryFn: () => seriesApi.fetch(),
});

export function useSeries() {
  return useQuery(seriesQueryOptions);
}
