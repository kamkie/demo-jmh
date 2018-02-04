package net.devopssolutions.demo.jmh;

import java.lang.reflect.Field;

public class IntParsers {

    private static final Field STRING_VALUE_FIELD;

    static {
        try {
            STRING_VALUE_FIELD = String.class.getDeclaredField("value");
            STRING_VALUE_FIELD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static int convertStringToIntLuxoft(String num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (final char c : num.toCharArray()) {
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntLuxoftFori(String num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) >= zeroAscii && num.charAt(i) <= nineAscii) {
                result = result * 10 + (num.charAt(i) - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntLuxoftFori2(String num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        final int length = num.length();
        for (int i = 0; i < length; i++) {
            final char c = num.charAt(i);
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntReflectionGetCharsJdk8(String num) throws IllegalAccessException {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (final char c : (char[]) STRING_VALUE_FIELD.get(num)) {
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntReflectionGetCharsJdk9(String num) throws IllegalAccessException {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (final byte c : (byte[]) STRING_VALUE_FIELD.get(num)) {
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntLuxoftChars(char[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (final char c : num) {
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntLuxoftChars2(char[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= zeroAscii && num[i] <= nineAscii) {
                result = result * 10 + (num[i] - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntLuxoftChars3(char[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (int i = 0; i < num.length; i++) {
            final char c = num[i];
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntUsingSwitch(String num) {
        int result = 0;
        for (final char c : num.toCharArray()) {
            switch (c) {
                case '0':
                    result = result * 10 + (0);
                    break;
                case '1':
                    result = result * 10 + (1);
                    break;
                case '2':
                    result = result * 10 + (2);
                    break;
                case '3':
                    result = result * 10 + (3);
                    break;
                case '4':
                    result = result * 10 + (4);
                    break;
                case '5':
                    result = result * 10 + (5);
                    break;
                case '6':
                    result = result * 10 + (6);
                    break;
                case '7':
                    result = result * 10 + (7);
                    break;
                case '8':
                    result = result * 10 + (8);
                    break;
                case '9':
                    result = result * 10 + (9);
                    break;
                default:
                    return -1;
            }
        }
        return result;
    }

    public static int convertStringToIntFromBytes(byte[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (byte c : num) {
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntFromBytesUtf16(byte[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (byte c : num) {
            if (c <= 0) {
                continue;
            }
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntFromBytes2Utf16(byte[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (int i = 0; i < num.length; i++) {
            if (num[i] <= 0) {
                continue;
            }
            if (num[i] >= zeroAscii && num[i] <= nineAscii) {
                result = result * 10 + (num[i] - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntFromBytes3Utf16(byte[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (int i = 0; i < num.length; i++) {
            final byte b = num[i];
            if (b <= 0) {
                continue;
            }
            if (b >= zeroAscii && b <= nineAscii) {
                result = result * 10 + (b - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntFromBytes2(byte[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (int i = 0; i < num.length; i++) {
            if (num[i] >= zeroAscii && num[i] <= nineAscii) {
                result = result * 10 + (num[i] - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntFromBytes3(byte[] num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (int i = 0; i < num.length; i++) {
            final byte b = num[i];
            if (b >= zeroAscii && b <= nineAscii) {
                result = result * 10 + (b - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int intValueOfStackOverflow(String str) {
        int ival = 0, idx = 0, end;
        boolean sign = false;
        char ch;

        if (str == null || (end = str.length()) == 0 ||
                ((ch = str.charAt(0)) < '0' || ch > '9')
                        && (!(sign = ch == '-') || ++idx == end || ((ch = str.charAt(idx)) < '0' || ch > '9')))
            throw new NumberFormatException(str);

        for (; ; ival *= 10) {
            ival += '0' - ch;
            if (++idx == end)
                return sign ? ival : -ival;
            if ((ch = str.charAt(idx)) < '0' || ch > '9')
                throw new NumberFormatException(str);
        }
    }

}
