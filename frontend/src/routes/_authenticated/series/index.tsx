import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute } from '@tanstack/react-router';

import { SearchBar } from '../../../components/input/SearchBar';
import { seriesQueryOptions } from '../../../data/queries/series/useSeries';
import type { ISeries } from '../../../data/series/series';
import { Button, Group, Stack, Table, type TableData } from '@mantine/core';
import { useDebouncedState } from '@mantine/hooks';
import { useModals } from '@mantine/modals';
import { Plus } from 'lucide-react';

import { queryClient } from '@/libs/query-client';

export const Route = createFileRoute('/_authenticated/series/')({
  component: SeriesPage,
  loader: () => queryClient.ensureQueryData(seriesQueryOptions),
});

function SeriesPage() {
  const { data: series } = useSuspenseQuery(seriesQueryOptions);
  const [search, setSearch] = useDebouncedState<string | null>(null, 200);

  return (
    <Stack>
      <Group align='flex-end'>
        <SearchBar label='Search series' setSearch={setSearch} />
        <CreateSeriesButton />
      </Group>
      <SeriesTable series={series.filter((s) => search === null || s.title.includes(search))} />
    </Stack>
  );
}

const CreateSeriesButton = () => {
  const modals = useModals();
  return (
    <Button
      color='brandYellow'
      ml='auto'
      onClick={() => modals.openContextModal('createSeriesModal', { title: 'Create series', size: 'lg', innerProps: {} })}
      leftSection={<Plus size={16} />}
      rightSection='Create'
    />
  );
};

const SeriesTable = ({ series }: { series: ISeries[] }) => {
  const data: TableData = {
    caption: 'All series',
    head: ['ID', 'Title', 'IsFinished'],
    body: series.map((s) => [s.id, s.title, s.isFinished]),
  };
  return <Table data={data} />;
};
