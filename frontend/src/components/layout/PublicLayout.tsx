import type { ReactNode } from 'react';

import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';

import logo from '../../../assets/logo.svg';
import { AppShell, Center, Container } from '@mantine/core';

export const PublicLayout = ({ children }: { children: ReactNode }) => {
  return (
    <AppShell header={{ height: 60 }} padding='md'>
      <AppShell.Header bg='brandYellow'>
        <Center h='100%'>
          <img src={logo} alt='Ninie' height={40} />
        </Center>
      </AppShell.Header>
      <AppShell.Main>
        <Container size='xl'>{children}</Container>
      </AppShell.Main>
      <TanStackRouterDevtools position='bottom-right' />
    </AppShell>
  );
};
