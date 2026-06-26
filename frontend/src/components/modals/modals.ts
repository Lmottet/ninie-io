import React from 'react';

const CreateAuthorModal = React.lazy(() => import('./CreateAuthorModal'));
const CreateBookModal = React.lazy(() => import('./CreateBookModal'));
const CreateReviewModal = React.lazy(() => import('./CreateReviewModal'));
const CreateSeriesModal = React.lazy(() => import('./CreateSeriesModal'));

const ModalsConfiguration = {
  createAuthorModal: CreateAuthorModal,
  createBookModal: CreateBookModal,
  createReviewModal: CreateReviewModal,
  createSeriesModal: CreateSeriesModal
};

declare module '@mantine/modals' {
  export interface MantineModalsOverride {
    modals: typeof ModalsConfiguration;
  }
}

export default ModalsConfiguration;
