import { seriesApi } from '../../api/business/seriesApi';
import { QueryKeys } from '../queryKeys';
import { queryOptions, useQuery } from '@tanstack/react-query';

export const seriesQueryOptions = queryOptions({
  queryKey: QueryKeys.series,
  queryFn: () => seriesApi.fetch()
});

export function useSeries() {
  return useQuery(seriesQueryOptions);
}
