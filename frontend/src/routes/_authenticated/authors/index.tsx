import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute } from '@tanstack/react-router';

import { SearchBar } from '../../../components/input/SearchBar';
import type { IAuthor } from '../../../data/author/author';
import { authorsQueryOptions } from '../../../data/queries/authors/useAuthors';
import { Button, Group, Stack, Table, Text, Title, type TableData } from '@mantine/core';
import { useDebouncedState } from '@mantine/hooks';
import { useModals } from '@mantine/modals';
import { Plus } from 'lucide-react';

import { queryClient } from '@/libs/query-client';

export const Route = createFileRoute('/_authenticated/authors/')({
  component: AuthorPage,
  loader: () => queryClient.ensureQueryData(authorsQueryOptions),
});

function AuthorPage() {
  const { data: authors } = useSuspenseQuery(authorsQueryOptions);
  const [search, setSearch] = useDebouncedState<string | null>(null, 200);
  const filtered = authors.filter((a) => search === null || (a.firstName + a.lastName).includes(search));

  return (
    <Stack>
      <Title order={2} mb='sm'>
        Authors
      </Title>
      <Group align='flex-end'>
        <SearchBar label='Search authors' setSearch={setSearch} />
        <CreateAuthorButton />
      </Group>
      {filtered.length === 0 ? <Text c='dimmed'>No authors match your search.</Text> : <AuthorTable authors={filtered} />}
    </Stack>
  );
}

const CreateAuthorButton = () => {
  const modals = useModals();
  return (
    <Button
      color='brandYellow'
      ml='auto'
      onClick={() => modals.openContextModal('createAuthorModal', { title: 'Create author', size: 'lg', innerProps: {} })}
      leftSection={<Plus size={16} />}
      rightSection='Create'
    />
  );
};

const AuthorTable = ({ authors }: { authors: IAuthor[] }) => {
  const data: TableData = {
    caption: 'All authors',
    head: ['First name', 'Last name'],
    body: authors.map((a) => [a.firstName, a.lastName]),
  };
  return <Table data={data} striped stickyHeader />;
};
