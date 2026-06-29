import { lazy, type FC } from 'react';

import type { CreateAuthorModalProps } from '../../features/authors/modals/CreateAuthorModal';
import type { CreateBookModalProps } from '../../features/books/modals/CreateBookModal';
import type { CreateReviewModalProps } from '../../features/books/modals/CreateReviewModal';
import type { CreateSeriesModalProps } from '../../features/series/modals/CreateSeriesModal';
import type { ContextModalProps } from '@mantine/modals';

const ModalsConfiguration = {
  createAuthorModal: lazy(() => import('../../features/authors/modals/CreateAuthorModal')) as FC<ContextModalProps<CreateAuthorModalProps>>,
  createBookModal: lazy(() => import('../../features/books/modals/CreateBookModal')) as FC<ContextModalProps<CreateBookModalProps>>,
  createReviewModal: lazy(() => import('../../features/books/modals/CreateReviewModal')) as FC<ContextModalProps<CreateReviewModalProps>>,
  createSeriesModal: lazy(() => import('../../features/series/modals/CreateSeriesModal')) as FC<ContextModalProps<CreateSeriesModalProps>>,
};

declare module '@mantine/modals' {
  export interface MantineModalsOverride {
    modals: typeof ModalsConfiguration;
  }
}

export default ModalsConfiguration;
