package net.devopssolutions.demo.jmh;

import org.openjdk.jmh.annotations.*;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 100, iterations = 5)
@Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 200, iterations = 5)
@Threads(1)
@Fork(0)
public class ParseInt {

    private static final Field STRING_VALUE_FIELD;

    static {
        try {
            STRING_VALUE_FIELD = String.class.getDeclaredField("value");
            STRING_VALUE_FIELD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @State(Scope.Thread)
    public static class StateStringToParse {
        @Param({"989819", "98989", "1", "2", "3257"})
        public String toParse;
        char[] toParseChars;
        byte[] toParseUtf8;
        byte[] toParseUtf16;

        @Setup(Level.Iteration)
        public void init() {
            toParseChars = toParse.toCharArray();
            toParseUtf8 = toParse.getBytes(StandardCharsets.UTF_8);
            toParseUtf16 = toParse.getBytes(StandardCharsets.UTF_16);
        }

        @TearDown(Level.Iteration)
        public void end() {
            toParseChars = null;
            toParseUtf8 = null;
            toParseUtf16 = null;
        }
    }

    @Benchmark
    public int parseStringToIntIntegerParseInt(StateStringToParse state) {
        return Integer.parseInt(state.toParse, 10);
    }

    @Benchmark
    public int parseStringToIntLuxoft(StateStringToParse state) {
        return convertStringToIntLuxoft(state.toParse);
    }

    @Benchmark
    public int parseStringToIntLuxoftFori(StateStringToParse state) {
        return convertStringToIntLuxoftFori(state.toParse);
    }

    @Benchmark
    public int parseStringToIntLuxoftFori2(StateStringToParse state) {
        return convertStringToIntLuxoftFori2(state.toParse);
    }

    @Benchmark
    public int parseStringToIntReflectionGetChars(StateStringToParse state) throws IllegalAccessException {
        return convertStringToIntReflectionGetChars(state.toParse);
    }

    @Benchmark
    public int parseStringToIntLuxoftChars(StateStringToParse state) {
        return convertStringToIntLuxoftChars(state.toParseChars);
    }

    @Benchmark
    public int parseStringToIntLuxoftChars2(StateStringToParse state) {
        return convertStringToIntLuxoftChars2(state.toParseChars);
    }

    @Benchmark
    public int parseStringToIntLuxoftChars3(StateStringToParse state) {
        return convertStringToIntLuxoftChars3(state.toParseChars);
    }

    @Benchmark
    public int parseStringToIntStackOverflow(StateStringToParse state) {
        return intValueOfStackOverflow(state.toParse);
    }

    @Benchmark
    public int parseStringToIntUsingSwitch(StateStringToParse state) {
        return convertStringToIntUsingSwitch(state.toParse);
    }

    @Benchmark
    public int parseStringToIntUtf8Bytes(StateStringToParse state) {
        return convertStringToIntFromBytes(state.toParseUtf8);
    }

    @Benchmark
    public int parseStringToIntUtf8Bytes2(StateStringToParse state) {
        return convertStringToIntFromBytes2(state.toParseUtf8);
    }

    @Benchmark
    public int parseStringToIntUtf8Bytes3(StateStringToParse state) {
        return convertStringToIntFromBytes3(state.toParseUtf8);
    }

    @Benchmark
    public int parseStringToIntUtf16Bytes(StateStringToParse state) {
        return convertStringToIntFromBytes(state.toParseUtf16);
    }

    @Benchmark
    public int parseStringToIntUtf16Bytes2(StateStringToParse state) {
        return convertStringToIntFromBytes2(state.toParseUtf16);
    }

    @Benchmark
    public int parseStringToIntUtf16Bytes3(StateStringToParse state) {
        return convertStringToIntFromBytes3(state.toParseUtf16);
    }

    @Benchmark
    public int parseStringToIntStringToUtf16Bytes(StateStringToParse state) {
        return convertStringToIntFromBytes(state.toParse.getBytes(StandardCharsets.UTF_16));
    }

    @Benchmark
    public int parseStringToIntStringToUtf8Bytes(StateStringToParse state) {
        return convertStringToIntFromBytes(state.toParse.getBytes(StandardCharsets.UTF_8));
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

    public static int convertStringToIntReflectionGetChars(String num) throws IllegalAccessException {
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
            byte b = num[i];
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
