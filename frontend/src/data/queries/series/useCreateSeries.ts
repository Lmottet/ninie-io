import { useMutation, useQueryClient } from '@tanstack/react-query';

import type { CreateSeriesRequest } from '../../../types/api/requests/CreateSeriesRequest';
import { seriesApi } from '../../series/api';
import { SERIES_QUERY_KEYS } from '../../series/query-keys';

export function useCreateSeries(onSuccess: () => void) {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (request: CreateSeriesRequest) => seriesApi.create(request),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: SERIES_QUERY_KEYS.series() });
      onSuccess();
    },
  });
}
