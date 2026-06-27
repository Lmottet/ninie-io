import { Button, Fieldset, Stack, Textarea } from '@mantine/core';
import { useForm } from '@mantine/form';
import type { ContextModalProps } from '@mantine/modals';

export type CreateReviewModalProps = Record<string, never>;

interface CreateReviewForm {
  content: string;
}

const CreateReviewModal = ({ context, id }: ContextModalProps<CreateReviewModalProps>) => {
  const form = useForm<CreateReviewForm>();
  return (
    <Fieldset legend='new review'>
      <form
        onSubmit={form.onSubmit(() => {
          context.closeModal(id);
        })}
      >
        <Stack>
          <Textarea label='Review' {...form.getInputProps('content')} />
          <Button type='submit' color='brandYellow' ml='auto'>
            Create
          </Button>
        </Stack>
      </form>
    </Fieldset>
  );
};

export default CreateReviewModal;
