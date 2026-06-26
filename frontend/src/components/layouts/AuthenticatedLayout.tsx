import { AppShell, Center, Container, Group, NavLink } from '@mantine/core';
import { Link } from '@tanstack/react-router';
import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';
import type { ReactNode } from 'react';

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
                ['/books', 'Books']
              ] as const
            ).map(([to, label]) => {
              return (
                <NavLink
                  component={Link}
                  c='charcoal.7'
                  color='charcoal.7'
                  w='150'
                  key={to}
                  label={label}
                  to={to}
                  activeOptions={
                    {
                      // If the route points to the root of it's parent,
                      // make sure it's only active if it's exact
                      // exact: to === '.',
                    }
                  }
                  preload='intent'
                />
              );
            })}
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
