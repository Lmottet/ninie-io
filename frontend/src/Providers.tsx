import type { ReactNode } from 'react';

import { QueryClientProvider } from '@tanstack/react-query';

import ModalsConfiguration from './libs/mantine/modals';
import { theme } from './theme';
import { MantineProvider } from '@mantine/core';
import { ModalsProvider } from '@mantine/modals';

import { queryClient } from '@/libs/query-client';

import '@mantine/carousel/styles.css';
import '@mantine/core/styles.css';
import '@mantine/dates/styles.css';

export const Providers = ({ children }: { children: ReactNode }) => (
  <QueryClientProvider client={queryClient}>
    <MantineProvider theme={theme} defaultColorScheme='light'>
      <ModalsProvider modals={ModalsConfiguration}>{children}</ModalsProvider>
    </MantineProvider>
  </QueryClientProvider>
);
