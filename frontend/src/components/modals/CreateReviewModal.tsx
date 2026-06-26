import { useCreateBook } from '../../data/queries/books/useCreateBook';
import type { CreateBookRequest } from '../../types/api/requests/CreateBookRequest';
import { AuthorSelector } from '../AuthorSelector';
import { SeriesSelector } from '../SeriesSelector';
import { Button, Fieldset, NumberInput, Stack, TextInput } from '@mantine/core';
import { useForm } from '@mantine/form';
import type { ContextModalProps } from '@mantine/modals';

type CreateBookForm = Omit<CreateBookRequest, 'authorId' | 'seriesId'> & { authorId: string; seriesId: string | null };

const CreateReviewModal = ({ context, id }: ContextModalProps) => {
  const createBookForm = useForm<CreateBookForm>();
  const { mutate: createBook } = useCreateBook(() => context.closeModal(id));
  return (
    <Fieldset legend='new book'>
      <form
        onSubmit={createBookForm.onSubmit((formData) =>
          createBook({ ...formData, authorId: parseInt(formData.authorId), seriesId: formData.seriesId == null ? null : parseInt(formData.seriesId) })
        )}
      >
        <Stack>
          <TextInput label='title' {...createBookForm.getInputProps('title')} />
          <NumberInput label='tome' {...createBookForm.getInputProps('tome')} />
          <AuthorSelector props={createBookForm.getInputProps('authorId')} />
          <SeriesSelector props={createBookForm.getInputProps('seriesId')} />
          <Button type='submit' color='brandYellow' ml='auto'>
            Create
          </Button>
        </Stack>
      </form>
    </Fieldset>
  );
};

export default CreateReviewModal;
