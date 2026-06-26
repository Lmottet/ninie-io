import { bookQueryOptions } from '../../../data/queries/books/useBook';
import { queryClient } from '../../../main';
import { Button, Stack, Title } from '@mantine/core';
import { modals } from '@mantine/modals';
import { IconPlus } from '@tabler/icons-react';
import { useSuspenseQuery } from '@tanstack/react-query';
import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/_authenticated/books/$bookId')({
  params: {
    parse: (params) => ({
      bookId: parseInt(params.bookId)
    }),
    stringify: ({ bookId }) => ({ bookId: `${bookId}` })
  },
  loader: ({ params }) => queryClient.ensureQueryData(bookQueryOptions(params.bookId)),
  component: BookPage
});

function BookPage() {
  const { bookId } = Route.useParams();
  const { data: book } = useSuspenseQuery(bookQueryOptions(bookId));

  return (
    <Stack>
      <Title>{book.title}</Title>
      <CreateReviewButton />
    </Stack>
  );
}

const CreateReviewButton = () => {
  return (
    <Button
      leftSection={<IconPlus />}
      rightSection='Review'
      mr='auto'
      onClick={() => modals.openContextModal({ title: 'Create review', modal: 'createReviewModal', innerProps: {} })}
    />
  );
};
