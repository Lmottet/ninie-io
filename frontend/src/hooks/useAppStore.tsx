import { create } from 'zustand';

interface AppConfigurationSlice {
  isDarkMode: boolean;
  toggleTheme: () => void;
}

type AppConfigurationSliceCreator = (
  set: (partial: Partial<AppConfigurationSlice>) => void,
  get: () => AppConfigurationSlice,
) => AppConfigurationSlice;

const createAppConfigurationSlice: AppConfigurationSliceCreator = (set, get) => ({
  isDarkMode: window.matchMedia?.('(prefers-color-scheme: dark)').matches ?? false,

  toggleTheme: () => set({ isDarkMode: !get().isDarkMode }),
});

type StoreState = AppConfigurationSlice;

export const useAppStore = create<StoreState>()((set, get) => ({
  ...createAppConfigurationSlice(
    (partial) => set(partial),
    () => get(),
  ),
}));
