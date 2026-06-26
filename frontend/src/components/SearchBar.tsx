import { TextInput } from '@mantine/core';
import { IconSearch } from '@tabler/icons-react';
import type { SetStateAction } from 'react';

export const SearchBar = ({ label, setSearch }: { label: string; setSearch: (e: SetStateAction<string | null>) => void }) => {
  return <TextInput label={label} miw='200' maw='300' leftSection={<IconSearch />} onChange={(e) => setSearch(e.currentTarget.value)} />;
};
