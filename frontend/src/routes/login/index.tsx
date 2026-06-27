import { createFileRoute, useNavigate } from '@tanstack/react-router';

import logo from '../../../assets/logo.svg';
import { PublicLayout } from '../../components/layout/PublicLayout';
import { useLogin } from '../../data/queries/login/useLogin';
import type { LoginRequest } from '../../types/api/requests/login-request';
import { Button, Center, Group, Paper, Stack, Text, TextInput } from '@mantine/core';
import { useForm } from '@mantine/form';
import { AtSign, Lock, LogIn } from 'lucide-react';

export const Route = createFileRoute('/login/')({
  component: LoginPage,
});

function LoginPage() {
  const navigate = useNavigate();
  const { mutate: login } = useLogin({
    onSuccess: () => {
      void navigate({ to: '/' });
    },
  });
  const loginForm = useForm<LoginRequest>({
    initialValues: {
      email: '',
      password: '',
    },
  });
  return (
    <PublicLayout>
      <Center>
        <Paper mt='xl'>
          <form
            onSubmit={loginForm.onSubmit((formData) => {
              login(formData);
            })}
          >
            <Stack w='400'>
              <Center>
                <img src={logo} alt='Ninie logo' width={300} height={300} />
              </Center>
              <Text c='dimmed' ta='center' size='sm'>
                Book Blog Admin
              </Text>
              <TextInput type='email' label='Email' placeholder='Email' leftSection={<AtSign size={16} />} {...loginForm.getInputProps('email')} />
              <TextInput
                type='password'
                label='Password'
                placeholder='Password'
                leftSection={<Lock size={16} />}
                {...loginForm.getInputProps('password')}
              />
              <Group justify='flex-end'>
                <Button leftSection={<LogIn size={16} />} rightSection='Login' type='submit' />
              </Group>
            </Stack>
          </form>
        </Paper>
      </Center>
    </PublicLayout>
  );
}
