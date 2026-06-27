import queryPlugin from '@tanstack/eslint-plugin-query';
import routerPlugin from '@tanstack/eslint-plugin-router';

import eslint from '@eslint/js';
import jsxA11y from 'eslint-plugin-jsx-a11y';
import prettier from 'eslint-plugin-prettier/recommended';
import react from 'eslint-plugin-react';
import reactHooks from 'eslint-plugin-react-hooks';
import security from 'eslint-plugin-security';
import sonarjs from 'eslint-plugin-sonarjs';
import unicorn from 'eslint-plugin-unicorn';
import { defineConfig, globalIgnores } from 'eslint/config';
import tseslint from 'typescript-eslint';

export default defineConfig([
  // ── Ignores ──────────────────────────────────────────────────────────────
  globalIgnores([
    'dist/**',
    'build/**',
    'out/**',
    '.storybook/**',
    '**/*.stories.*',
    'src/routeTree.gen.ts', // TanStack Router generated file
    'scripts/**',
    'node_modules/**',
    '*.config.*',
  ]),

  // ── Base configs (non-typed) ──────────────────────────────────────────────
  eslint.configs.recommended,
  react.configs.flat.recommended,
  reactHooks.configs.flat.recommended,
  jsxA11y.flatConfigs.recommended,
  unicorn.configs.recommended,
  sonarjs.configs.recommended,
  security.configs.recommended,

  // ── TanStack plugins ──────────────────────────────────────────────────────
  ...queryPlugin.configs['flat/recommended'],
  ...routerPlugin.configs['flat/recommended'],

  ...tseslint.configs.strictTypeChecked,
  ...tseslint.configs.stylisticTypeChecked,

  // ── TypeScript typed linting (scoped to TS/TSX files) ────────────────────
  {
    files: ['**/*.{ts,tsx}'],
    languageOptions: {
      parserOptions: {
        tsconfigRootDir: process.cwd(),
        project: ['./tsconfig.json'],
      },
    },
    settings: {
      react: { version: 'detect' },
    },
    rules: {
      // ── TypeScript ──────────────────────────────────────────────────────
      '@typescript-eslint/only-throw-error': [
        'error',
        {
          allow: [{ from: 'package', package: '@tanstack/router-core', name: 'Redirect' }],
        },
      ],
      '@typescript-eslint/no-explicit-any': 'error',
      '@typescript-eslint/no-unsafe-assignment': 'error',
      '@typescript-eslint/no-unsafe-call': 'error',
      '@typescript-eslint/no-unsafe-member-access': 'error',
      '@typescript-eslint/no-unsafe-return': 'error',
      '@typescript-eslint/no-misused-promises': ['error', { checksVoidReturn: false }],
      '@typescript-eslint/no-floating-promises': ['error', { ignoreVoid: true }],
      '@typescript-eslint/restrict-template-expressions': ['error', { allowNumber: true }],
      '@typescript-eslint/switch-exhaustiveness-check': 'error',
      '@typescript-eslint/no-unused-vars': ['error', { argsIgnorePattern: '^_' }],

      // ── React ───────────────────────────────────────────────────────────
      'react/react-in-jsx-scope': 'off', // React 17+ JSX transform
      'react/prop-types': 'off', // TypeScript handles this
      'react/jsx-no-literals': 'warn', // enforce i18n discipline
      'react/prefer-stateless-function': 'off', // obsolete in hooks era
      'react/no-deprecated': 'error',

      // ── Unicorn ─────────────────────────────────────────────────────────
      'unicorn/filename-case': 'off', // handled per-extension below
      'unicorn/no-null': 'off',
      'unicorn/no-array-reduce': 'off',
      'unicorn/switch-case-braces': 'off',
      'unicorn/number-literal-case': 'off',
      'unicorn/prefer-module': 'off',
      'unicorn/prevent-abbreviations': 'off', // too noisy without custom config

      // ── SonarJS ─────────────────────────────────────────────────────────
      'sonarjs/todo-tag': 'warn',
      'sonarjs/no-commented-code': 'warn',
      'sonarjs/function-return-type': 'warn',

      // ── Security ────────────────────────────────────────────────────────
      'security/detect-object-injection': 'warn',

      // ── General ─────────────────────────────────────────────────────────
      'no-restricted-syntax': [
        'error',
        {
          selector: 'TSEnumDeclaration',
          message: 'Enums are discouraged. Prefer union types or `as const`.',
        },
      ],
    },
  },

  // ── Filename casing  ─────────────────
  {
    files: ['**/*.ts'],
    rules: {
      'unicorn/filename-case': [
        'warn',
        {
          case: 'kebabCase',
          checkDirectories: false,
          ignore: [/^use[A-Z]/], // allow useMyHook.ts
        },
      ],
    },
  },
  {
    files: ['**/*.tsx'],
    ignores: ['**/routes/**'],
    rules: {
      'unicorn/filename-case': [
        'error',
        {
          case: 'pascalCase',
          checkDirectories: false,
          ignore: [/^use[A-Z]/], // allow useMyHook.tsx
        },
      ],
    },
  },

  // ── Prettier (last — overrides formatting-conflicting rules) ─────────────
  prettier,
  {
    rules: {
      'prettier/prettier': 'warn',
    },
  },
]);
