import { useCreateAuthor } from '../../data/queries/authors/useCreateAuthor';
import type { CreateAuthorRequest } from '../../types/api/requests/CreateAuthorRequest';
import { Button, Fieldset, Stack, TextInput } from '@mantine/core';
import { useForm } from '@mantine/form';
import type { ContextModalProps } from '@mantine/modals';

const CreateAuthorModal = ({ context, id }: ContextModalProps) => {
  const createAuthorForm = useForm<CreateAuthorRequest>();
  const { mutate: createAuthor } = useCreateAuthor(() => context.closeModal(id));
  return (
    <Fieldset legend='new author'>
      <form onSubmit={createAuthorForm.onSubmit((formData) => createAuthor(formData))}>
        <Stack>
          <TextInput label='first name' {...createAuthorForm.getInputProps('firstName')} />
          <TextInput label='last name' {...createAuthorForm.getInputProps('lastName')} />
          <Button type='submit' color='brandYellow' ml='auto'>
            Create
          </Button>
        </Stack>
      </form>
    </Fieldset>
  );
};

export default CreateAuthorModal;
