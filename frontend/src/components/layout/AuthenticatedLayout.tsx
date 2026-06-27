import type { ReactNode } from 'react';

import { Link } from '@tanstack/react-router';
import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';

import { AppShell, Center, Container, Group, NavLink } from '@mantine/core';

export const AuthenticatedLayout = ({ children }: { children: ReactNode }) => {
  return (
    <AppShell header={{ height: 60 }} padding='md'>
      <AppShell.Header bg='brandYellow'>
        <Center>
          <Group h='100%' px='md' mt='md'>
            {(
              [
                ['/', 'Home'],
                ['/authors', 'Authors'],
                ['/series', 'Series'],
                ['/books', 'Books'],
              ] as const
            ).map(([to, label]) => (
              <NavLink component={Link} c='charcoal.7' color='charcoal.7' w='150' key={to} label={label} to={to} preload='intent' />
            ))}
          </Group>
        </Center>
      </AppShell.Header>
      <AppShell.Main>
        <Container size='xl'>{children}</Container>
      </AppShell.Main>
      <TanStackRouterDevtools position='bottom-right' />
    </AppShell>
  );
};
