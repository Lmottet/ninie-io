import { useSeries } from '../data/queries/series/useSeries';
import { Loader, Select, type SelectProps } from '@mantine/core';

export const SeriesSelector = ({ props }: { props: SelectProps }) => {
  const { data: series } = useSeries();
  if (!series) return <Loader />;
  return <Select label='Select series' data={series.map((a) => ({ value: a.id + '', label: a.title }))} {...props} />;
};
