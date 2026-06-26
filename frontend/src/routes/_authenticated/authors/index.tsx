import { SearchBar } from '../../../components/SearchBar';
import { authorsQueryOptions } from '../../../data/queries/authors/useAuthors';
import { queryClient } from '../../../main';
import type { IAuthor } from '../../../types/api/responses/IAuthor';
import { Button, Group, Stack, Table, type TableData } from '@mantine/core';
import { useDebouncedState } from '@mantine/hooks';
import { modals } from '@mantine/modals';
import { IconPlus } from '@tabler/icons-react';
import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_authenticated/authors/')({
  component: AuthorPage,
  loader: () => queryClient.ensureQueryData(authorsQueryOptions)
});

function AuthorPage() {
  const { data: authors } = useSuspenseQuery(authorsQueryOptions);
  const [search, setSearch] = useDebouncedState<string | null>(null, 200);

  return (
    <Stack>
      <Group align='flex-end'>
        <SearchBar label='Search authors' setSearch={setSearch} />
        <CreateAuthorButton />
      </Group>

      <AuthorTable authors={authors.filter((a) => search === null || (a.firstName + a.lastName).includes(search))} />
    </Stack>
  );
}

const CreateAuthorButton = () => (
  <Button
    color='brandYellow'
    ml='auto'
    onClick={() =>
      modals.openContextModal({
        modal: 'createAuthorModal',
        title: 'Create author',
        size: 'lg',
        innerProps: {}
      })
    }
    leftSection={<IconPlus />}
    rightSection='Create'
  />
);

const AuthorTable = ({ authors }: { authors: IAuthor[] }) => {
  const data: TableData = {
    caption: 'All authors',
    head: ['ID', 'First name', 'Last name'],
    body: authors.map((a) => [a.id, a.firstName, a.lastName])
  };
  return <Table data={data} striped stickyHeader />;
};
