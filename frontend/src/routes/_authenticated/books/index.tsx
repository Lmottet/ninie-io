import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute, Link } from '@tanstack/react-router';

import { SearchBar } from '../../../components/input/SearchBar';
import type { IBook } from '../../../data/book/book';
import { booksQueryOptions } from '../../../data/queries/books/useBooks';
import { ActionIcon, Button, Group, Stack, Table, type TableData } from '@mantine/core';
import { useDebouncedState } from '@mantine/hooks';
import { useModals } from '@mantine/modals';
import { Plus, Search } from 'lucide-react';

import { queryClient } from '@/libs/query-client';

export const Route = createFileRoute('/_authenticated/books/')({
  component: BooksPage,
  loader: () => queryClient.ensureQueryData(booksQueryOptions),
});

function BooksPage() {
  const { data: books } = useSuspenseQuery(booksQueryOptions);
  const [search, setSearch] = useDebouncedState<string | null>(null, 200);

  return (
    <Stack>
      <Group align='flex-end'>
        <SearchBar label='Search books' setSearch={setSearch} />
        <CreateBookButton />
      </Group>
      <BookTable books={books.filter((b) => search === null || b.title.includes(search))} />
    </Stack>
  );
}

const CreateBookButton = () => {
  const modals = useModals();
  return (
    <Button
      color='brandYellow'
      ml='auto'
      onClick={() => modals.openContextModal('createBookModal', { title: 'Create book', size: 'lg', innerProps: {} })}
      leftSection={<Plus size={16} />}
      rightSection='Create'
    />
  );
};

const BookTable = ({ books }: { books: IBook[] }) => {
  const data: TableData = {
    caption: 'All books',
    head: ['ID', 'Title', 'Tome'],
    body: books.map((b) => [<DetailIcon to={`/books/${b.id}`} key={b.id} />, b.title, b.tome]),
  };
  return <Table data={data} striped stickyHeader />;
};

const DetailIcon = ({ to }: { to: string }) => (
  <ActionIcon component={Link} to={to} preload='intent' variant='transparent'>
    <Search size={16} />
  </ActionIcon>
);
