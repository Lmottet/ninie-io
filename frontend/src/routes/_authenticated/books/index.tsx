import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute, Link } from '@tanstack/react-router';

import { SearchBar } from '../../../components/input/SearchBar';
import type { IBook } from '../../../data/book/book';
import { booksQueryOptions } from '../../../data/queries/books/useBooks';
import { Button, Group, Stack, Table, Text, Title, type TableData } from '@mantine/core';
import { useDebouncedState } from '@mantine/hooks';
import { useModals } from '@mantine/modals';
import { Plus } from 'lucide-react';

import { queryClient } from '@/libs/query-client';

export const Route = createFileRoute('/_authenticated/books/')({
  component: BooksPage,
  loader: () => queryClient.ensureQueryData(booksQueryOptions),
});

function BooksPage() {
  const { data: books } = useSuspenseQuery(booksQueryOptions);
  const [search, setSearch] = useDebouncedState<string | null>(null, 200);
  const filtered = books.filter((b) => search === null || b.title.includes(search));

  return (
    <Stack>
      <Title order={2} mb='sm'>
        Books
      </Title>
      <Group align='flex-end'>
        <SearchBar label='Search books' setSearch={setSearch} />
        <CreateBookButton />
      </Group>
      {filtered.length === 0 ? <Text c='dimmed'>No books match your search.</Text> : <BookTable books={filtered} />}
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
    head: ['Title', 'Tome'],
    body: books.map((b) => [
      <Link
        key={b.id}
        to='/books/$bookId'
        params={{ bookId: Number.parseInt(b.id) }}
        preload='intent'
        style={{ textDecoration: 'none', color: 'inherit' }}
      >
        {b.title}
      </Link>,
      b.tome,
    ]),
  };
  return <Table data={data} striped stickyHeader />;
};
