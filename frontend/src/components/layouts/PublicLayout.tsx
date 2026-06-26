import { AppShell, Container } from '@mantine/core';
import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';
import type { ReactNode } from 'react';

export const PublicLayout = ({ children }: { children: ReactNode }) => {
  return (
    <AppShell header={{ height: 60 }} padding='md'>
      <AppShell.Header bg='brandYellow'></AppShell.Header>
      <AppShell.Main>
        <Container size='xl'>{children}</Container>
      </AppShell.Main>
      <TanStackRouterDevtools position='bottom-right' />
    </AppShell>
  );
};
