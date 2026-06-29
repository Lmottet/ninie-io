import * as React from 'react';
import ReactDOM from 'react-dom/client';

import { createRouter, ErrorComponent, RouterProvider } from '@tanstack/react-router';
import { TanStackRouterDevtools } from '@tanstack/react-router-devtools';

import { Providers } from './Providers';
import { routeTree } from './routeTree.gen';
import { Loader, Stack, Text, Title } from '@mantine/core';

const router = createRouter({
  routeTree,
  defaultPendingComponent: () => <Loader />,
  defaultNotFoundComponent: () => (
    <Stack>
      <Title>Oops</Title>
      <Text>Ninie lost that. Sowwy !</Text>
    </Stack>
  ),
  defaultErrorComponent: ({ error }) => <ErrorComponent error={error} />,
  defaultPreload: 'intent',
  defaultPreloadStaleTime: 0,
  scrollRestoration: true,
});

declare module '@tanstack/react-router' {
  interface Register {
    router: typeof router;
  }
}

const rootElement = document.querySelector<HTMLElement>('#app');
if (rootElement && !rootElement.innerHTML) {
  const root = ReactDOM.createRoot(rootElement);
  root.render(
    <React.StrictMode>
      <Providers>
        <RouterProvider router={router} />
        <TanStackRouterDevtools router={router} />
      </Providers>
    </React.StrictMode>,
  );
}
