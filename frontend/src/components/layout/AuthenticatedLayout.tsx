import type { ReactNode } from 'react';

import { Link, useMatchRoute, useNavigate } from '@tanstack/react-router';
import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';

import logo from '../../../assets/logo.svg';
import { useLogout } from '../../data/queries/login/useLogout';
import { AppShell, Button, Container, Group, NavLink } from '@mantine/core';
import { LogOut } from 'lucide-react';

import { queryClient } from '@/libs/query-client';

const NAV_LINKS = [
  ['/authors', 'Authors'],
  ['/series', 'Series'],
  ['/books', 'Books'],
] as const;

export const AuthenticatedLayout = ({ children }: { children: ReactNode }) => {
  const navigate = useNavigate();
  const matchRoute = useMatchRoute();
  const { mutate: logout } = useLogout({
    onSuccess: () => {
      queryClient.clear();
      void navigate({ to: '/login' });
    },
  });

  return (
    <AppShell header={{ height: 60 }} padding='md'>
      <AppShell.Header bg='brandYellow'>
        <Group h='100%' px='md' justify='space-between'>
          <img src={logo} alt='Ninie' height={40} />
          <Group>
            {NAV_LINKS.map(([to, label]) => (
              <NavLink
                component={Link}
                c='charcoal.7'
                color='charcoal.7'
                w={120}
                key={to}
                label={label}
                to={to}
                preload='intent'
                active={!!matchRoute({ to, fuzzy: true })}
              />
            ))}
          </Group>
          <Button
            variant='subtle'
            c='charcoal.7'
            leftSection={<LogOut size={16} />}
            onClick={() => {
              logout();
            }}
          >
            Logout
          </Button>
        </Group>
      </AppShell.Header>
      <AppShell.Main>
        <Container size='xl'>{children}</Container>
      </AppShell.Main>
      <TanStackRouterDevtools position='bottom-right' />
    </AppShell>
  );
};
