import { TextInput } from '@mantine/core';
import { Search } from 'lucide-react';

interface Props {
  label: string;
  setSearch: (value: string | null) => void;
}

export const SearchBar = ({ label, setSearch }: Props) => (
  <TextInput label={label} leftSection={<Search size={16} />} onChange={(e) => setSearch(e.currentTarget.value || null)} />
);
