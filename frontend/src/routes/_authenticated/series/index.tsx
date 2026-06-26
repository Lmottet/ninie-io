import { SearchBar } from '../../../components/SearchBar';
import { seriesQueryOptions } from '../../../data/queries/series/useSeries';
import { queryClient } from '../../../main';
import type { ISeries } from '../../../types/api/responses/ISeries';
import { Button, Group, Stack, Table, type TableData } from '@mantine/core';
import { useDebouncedState } from '@mantine/hooks';
import { modals } from '@mantine/modals';
import { IconPlus } from '@tabler/icons-react';
import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_authenticated/series/')({
  component: SeriesPage,
  loader: () => queryClient.ensureQueryData(seriesQueryOptions)
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
  return (
    <Button
      color='brandYellow'
      ml='auto'
      onClick={() =>
        modals.openContextModal({
          modal: 'createSeriesModal',
          title: 'Create series',
          size: 'lg',
          innerProps: {}
        })
      }
      leftSection={<IconPlus />}
      rightSection='Create'
    />
  );
};

const SeriesTable = ({ series }: { series: ISeries[] }) => {
  const data: TableData = {
    caption: 'All series',
    head: ['ID', 'Title', 'IsFinished'],
    body: series.map((a) => [a.id, a.title, a.isFinished])
  };
  return <Table data={data} />;
};
