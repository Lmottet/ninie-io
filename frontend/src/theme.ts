import { DEFAULT_THEME, createTheme, mergeMantineTheme, rem } from '@mantine/core';

const themeOverride = createTheme({
  colors: {
    brandYellow: ['#FFF9E6', '#FFF1C2', '#FFE89B', '#FFDD72', '#FDD14A', '#F7C948', '#E6B83C', '#D1A632', '#B89026', '#99791C'],
    charcoal: ['#F2F4F6', '#E0E3E7', '#C6CAD1', '#A6ACB6', '#7D8291', '#2D3142', '#272B3A', '#212531', '#1B1E28', '#14161E'],
    steelBlue: ['#F0F6FA', '#D9E7F2', '#B8D2E6', '#93BAD7', '#6D9DC5', '#5E8CAF', '#507A98', '#436981', '#35566B', '#274255']
  },
  primaryColor: 'brandYellow',
  primaryShade: 5,
  fontFamily: 'Inter, sans-serif',
  fontSizes: {
    xs: rem(12),
    sm: rem(14),
    md: rem(16),
    lg: rem(18),
    xl: rem(20)
  },
  defaultRadius: 'md',
  components: {
    Button: {
      defaultProps: {
        radius: 'md',
        size: 'md'
      }
    },
    Modal: {
      defaultProps: {
        closeOnClickOutside: false
      }
    },
    Stack: {
      defaultProps: {
        gap: 'sm'
      }
    },
    Table: {
      defaultProps: {
        verticalSpacing: 'sm',
        striped: true,
        withColumnBorders: true,
        withRowBorders: false,
        stickyHeader: true,
        stickyHeaderOffset: 60
      }
    },
    Paper: {
      defaultProps: {
        radius: 'md',
        shadow: 'xs',
        p: 'md',
        withBorder: true
      }
    }
  }
});

export const theme = mergeMantineTheme(DEFAULT_THEME, themeOverride);
