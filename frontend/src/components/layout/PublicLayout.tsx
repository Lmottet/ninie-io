import type { ReactNode } from 'react';

import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';

import { AppShell, Container } from '@mantine/core';

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
