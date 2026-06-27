import { createFileRoute, Outlet, redirect } from '@tanstack/react-router';

import { AuthenticatedLayout } from '../components/layout/AuthenticatedLayout';
import { userApi } from '../data/user/user-api';

export const Route = createFileRoute('/_authenticated')({
  beforeLoad: async ({ location }) => {
    try {
      await userApi.tryGet();
    } catch {
      throw redirect({
        to: '/login',
        search: { redirect: location.href },
      });
    }
  },
  component: AuthLayout,
});

function AuthLayout() {
  return (
    <AuthenticatedLayout>
      <Outlet />
    </AuthenticatedLayout>
  );
}
