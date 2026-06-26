import { FlatCompat } from '@eslint/eslintrc';
import eslintPluginsSecurity from 'eslint-plugin-security';
import sonarjs from 'eslint-plugin-sonarjs';
import unicorn from 'eslint-plugin-unicorn';
import { defineConfig } from 'eslint/config';
import path from 'node:path';
import { fileURLToPath } from 'node:url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const compat = new FlatCompat({
  baseDirectory: __dirname
});

export default defineConfig([
  eslintPluginsSecurity.configs.recommended,
  ...compat.extends('prettier', 'plugin:@tanstack/query/recommended'),
  {
    files: ['**/*.ts', '**/*.tsx'],
    plugins: {
      unicorn,
      sonarjs
    },
    rules: {
      ...unicorn.configs.recommended.rules,
      ...sonarjs.configs.recommended.rules,
      'unicorn/filename-case': 'off',
      'unicorn/prevent-abbreviations': 'off',
      'unicorn/switch-case-braces': 'off',
      'unicorn/no-null': 'off',
      'unicorn/no-array-reduce': 'off',
      "unicorn/number-literal-case": "off",
      'sonarjs/todo-tag': 'warn',
      'no-restricted-syntax': [
        'error',
        {
          selector: 'TSEnumDeclaration',
          message: 'Enums are discouraged. Prefer union types or `as const` with type derivation.'
        }
      ]
    }
  }
]);
