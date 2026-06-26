import { AuthenticatedLayout } from '../components/layouts/AuthenticatedLayout';
import { Outlet, createFileRoute, redirect } from '@tanstack/react-router';
import { useAppStore } from '../hooks/useAppStore';

export const Route = createFileRoute('/_authenticated')({
  beforeLoad: ({ location }) => {
    if (! useAppStore.getState().isAuthenticated) {
      throw redirect({
        to: '/login',
        search: {
          redirect: location.href
        }
      });
    }
  },
  component: AuthLayout
});

function AuthLayout() {
  return (
    <AuthenticatedLayout>
      <Outlet />
    </AuthenticatedLayout>
  );
}
