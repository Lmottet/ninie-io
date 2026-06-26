import type { CreateSeriesRequest } from '../../../types/api/requests/CreateSeriesRequest';
import { seriesApi } from '../../api/business/seriesApi';
import { QueryKeys } from '../queryKeys';
import { useMutation, useQueryClient } from '@tanstack/react-query';

export function useCreateSeries(onSuccess: () => void) {
  const queryClient = useQueryClient();
  return useMutation({
    mutationFn: (request: CreateSeriesRequest) => seriesApi.create(request),
    onSuccess: () => {
      queryClient.invalidateQueries({ queryKey: QueryKeys.series });
      onSuccess();
    }
  });
}
