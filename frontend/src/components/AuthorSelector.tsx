import { useAuthors } from '../data/queries/authors/useAuthors';
import { Loader, Select, type SelectProps } from '@mantine/core';

export const AuthorSelector = ({ props }: { props: SelectProps }) => {
  const { data: authors } = useAuthors();
  if (!authors) return <Loader />;
  return <Select label='Select author' data={authors.map((a) => ({ value: a.id + '', label: `${a.firstName} ${a.lastName}` }))} {...props} />;
};
