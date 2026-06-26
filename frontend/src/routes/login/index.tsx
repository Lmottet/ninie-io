import { PublicLayout } from '../../components/layouts/PublicLayout';
import { useLogin } from '../../data/queries/login/useLogin';
import type { LoginRequest } from '../../types/api/requests/LoginRequest';
import { Button, Center, Group, Paper, Stack, TextInput } from '@mantine/core';
import { useForm } from '@mantine/form';
import { IconAt, IconLock, IconLogin } from '@tabler/icons-react';
import { createFileRoute } from '@tanstack/react-router';

export const Route = createFileRoute('/login/')({
  component: LoginPage
});

function LoginPage() {
  const { mutate: login } = useLogin();
  const loginForm = useForm<LoginRequest>({
    initialValues: {
      email: '',
      password: ''
    }
  });
  return (
    <PublicLayout>
      <Center>
        <Paper mt='xl'>
          <form onSubmit={loginForm.onSubmit((formData) => login(formData))}>
            <Stack w='400'>
              <Center>
                <img src='../../../assets/logo.svg' alt='Ninie logo' width='300' height='300' />
              </Center>

              <TextInput type='email' label='Email' placeholder='Email' leftSection={<IconAt />} {...loginForm.getInputProps('email')} />
              <TextInput type='password' label='Password' placeholder='Password' leftSection={<IconLock />} {...loginForm.getInputProps('password')} />
              <Group justify='space-between'>
                <Button variant='transparent'>Forgot password</Button>
                <Button leftSection={<IconLogin />} rightSection='Login' type='submit' />
              </Group>
            </Stack>
          </form>
        </Paper>
      </Center>
    </PublicLayout>
  );
}
