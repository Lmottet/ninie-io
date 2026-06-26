export const QueryKeys = {
  authors: ['authors'] as const,
  books: ['books'] as const,
  book: (bookId: number) => ['book', bookId] as const,
  series: ['series'] as const
};
