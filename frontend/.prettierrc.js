/** @type {import("@ianvs/prettier-plugin-sort-imports").PrettierConfig} */
export default {
  // ── Formatting ────────────────────────────────────────────────────────────
  printWidth: 150,
  singleQuote: true,
  jsxSingleQuote: true,
  semi: true,
  tabWidth: 2,
  trailingComma: 'all',
  endOfLine: 'lf',
  bracketSameLine: false,
  arrowParens: 'always',

  // ── Import sorting ────────────────────────────────────────────────────────
  plugins: ['@ianvs/prettier-plugin-sort-imports'],
  importOrder: [
    '^react$',
    '^react-dom$',
    '^react-dom/(.*)$',
    '',
    '^@tanstack/(.*)$',
    '',
    '<BUILTIN_MODULES>',
    '',
    '<THIRD_PARTY_MODULES>',
    '',
    '^@/(.*)$',
    '^~/(.*)$',
    '',
    String.raw`\.css$`, // CSS last
    String.raw`\.scss$`,
  ],
};
