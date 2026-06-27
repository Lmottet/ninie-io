import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute, Link } from '@tanstack/react-router';

import { bookQueryOptions } from '../../../data/queries/books/useBook';
import { Anchor, Button, Paper, Stack, Text, Title } from '@mantine/core';
import { useModals } from '@mantine/modals';
import { Plus } from 'lucide-react';

import { queryClient } from '@/libs/query-client';

export const Route = createFileRoute('/_authenticated/books/$bookId')({
  params: {
    parse: (params) => ({ bookId: Number.parseInt(params.bookId) }),
    stringify: ({ bookId }) => ({ bookId: `${bookId}` }),
  },
  loader: ({ params }) => queryClient.ensureQueryData(bookQueryOptions(params.bookId)),
  component: BookPage,
});

function BookPage() {
  const { bookId } = Route.useParams();
  const { data: book } = useSuspenseQuery(bookQueryOptions(bookId));

  return (
    <Stack>
      <Anchor component={Link} to='/books' c='dimmed' size='sm'>
        ← Back to Books
      </Anchor>
      <Paper>
        <Stack>
          <Title>{book.title}</Title>
          <Text c='dimmed'>Volume {book.tome}</Text>
          <CreateReviewButton />
        </Stack>
      </Paper>
    </Stack>
  );
}

const CreateReviewButton = () => {
  const modals = useModals();
  return (
    <Button
      leftSection={<Plus size={16} />}
      rightSection='Review'
      mr='auto'
      onClick={() => modals.openContextModal('createReviewModal', { title: 'Create review', innerProps: {} })}
    />
  );
};
