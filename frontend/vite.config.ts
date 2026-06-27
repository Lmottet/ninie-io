import { devtools } from '@tanstack/devtools-vite';
import { tanstackRouter } from '@tanstack/router-plugin/vite';

import react from '@vitejs/plugin-react';
import { defineConfig } from 'vite';

const config = defineConfig({
  css: {
    postcss: './postcss.config.js',
  },
  plugins: [
    tanstackRouter({
      autoCodeSplitting: true,
      target: 'react',
    }),
    react(),
    devtools(),
  ],
  resolve: {
    tsconfigPaths: true,
  },
});

export default config;
