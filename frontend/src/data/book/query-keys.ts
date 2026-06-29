export const BOOK_QUERY_KEYS = {
  books: () => ['books'] as const,
  book: (bookId: number) => ['book', bookId] as const,
};
