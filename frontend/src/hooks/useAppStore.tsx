import { jwtDecode } from 'jwt-decode';
import { create } from 'zustand';

export interface AppJwt {
  sub: string;
  userId: string;
  firstName: string;
  lastName: string;
  email: string;
  longSession: string;
  exp: number;
}

export interface AuthState {
  accessToken: string | null;
  rememberDeviceToken: string | null;
}

interface AuthSlice extends AuthState {
  authExpiration: string | null;
  deviceRemembranceExpiration: string | null;
  longSession: boolean | null;

  isAuthenticated: () => boolean;
  isRemembered: () => boolean;

  signIn: (accessToken: string, rememberDeviceToken?: string | null) => void;
  refreshAuth: (accessToken: string, rememberDeviceToken?: string | null) => void;
  signOut: () => void;
  rememberDevice: (rememberDeviceToken: string) => void;
}

type AuthSliceCreator = (set: (partial: Partial<AuthSlice>) => void, get: () => AuthSlice) => AuthSlice;

const createAuthSlice: AuthSliceCreator = (set, get) => ({
  accessToken: null,
  rememberDeviceToken: null,
  authExpiration: null,
  deviceRemembranceExpiration: null,
  longSession: null,

  isAuthenticated: () => {
    const expiration = get().authExpiration;
    return expiration ? new Date(expiration) > new Date() : false;
  },

  isRemembered: () => {
    const expiration = get().deviceRemembranceExpiration;
    return expiration ? new Date(expiration) > new Date() : false;
  },

  signIn: (accessToken: string, rememberDeviceToken?: string | null) => {
    get().refreshAuth(accessToken, rememberDeviceToken);
  },

  refreshAuth: (accessToken: string, rememberDeviceToken?: string | null) => {
    const decoded = jwtDecode<AppJwt>(accessToken);
    const authExpiration = new Date(decoded.exp * 1000);

    set({
      accessToken,
      authExpiration: authExpiration.toISOString(),
      longSession: decoded.longSession === 'True'
    });

    if (rememberDeviceToken) {
      const rememberDecoded = jwtDecode<AppJwt>(rememberDeviceToken);
      const rememberExpiration = new Date(rememberDecoded.exp * 1000);

      set({
        rememberDeviceToken,
        deviceRemembranceExpiration: rememberExpiration.toISOString()
      });
    }
  },

  rememberDevice: (rememberDeviceToken: string) => {
    set({ rememberDeviceToken });
  },

  signOut: () => {
    set({
      accessToken: null,
      authExpiration: null,
      deviceRemembranceExpiration: null,
      rememberDeviceToken: null
    });
  }
});

interface AppConfigurationSlice {
  isDarkMode: boolean;
  toggleTheme: () => void;
}

type AppConfigurationSliceCreator = (set: (partial: Partial<AppConfigurationSlice>) => void, get: () => AppConfigurationSlice) => AppConfigurationSlice;

const createAppConfigurationSlice: AppConfigurationSliceCreator = (set, get) => ({
  isDarkMode: window.matchMedia?.('(prefers-color-scheme: dark)').matches ?? false,

  toggleTheme: () => set({ isDarkMode: !get().isDarkMode })
});

type StoreState = AuthSlice & AppConfigurationSlice;

export const useAppStore = create<StoreState>()((set, get) => ({
  ...createAuthSlice(
    (partial) => set(partial),
    () => get()
  ),
  ...createAppConfigurationSlice(
    (partial) => set(partial),
    () => get()
  )
}));
