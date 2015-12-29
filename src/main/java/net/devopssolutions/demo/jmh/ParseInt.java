package net.devopssolutions.demo.jmh;

import org.openjdk.jmh.annotations.*;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

@Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 100, iterations = 5)
@Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 100, iterations = 5)
@Threads(1)
@Fork(0)
public class ParseInt {

    private static final String toParse = "98989";
    private static final char[] toParseChars = toParse.toCharArray();
    private static final byte[] toParseUtf8 = toParse.getBytes(StandardCharsets.UTF_8);
    private static final byte[] toParseUtf16 = toParse.getBytes(StandardCharsets.UTF_16);
    private static final Unsafe unsafe;
    private static final Field STRING_VALUE_FIELD;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    static {
        try {
            STRING_VALUE_FIELD = String.class.getDeclaredField("value");
            STRING_VALUE_FIELD.setAccessible(true);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    @Benchmark
    public int parseStringToIntIntegerParseInt() {
        return Integer.parseInt(toParse, 10);
    }

    @Benchmark
    public int parseStringToIntLuxoft() {
        return convertStringToIntLuxoft(toParse);
    }

    @Benchmark
    public int parseStringToIntLuxoftFori() {
        return convertStringToIntLuxoftFori(toParse);
    }

    @Benchmark
    public int parseStringToIntLuxoftFori2() {
        return convertStringToIntLuxoftFori2(toParse);
    }

    @Benchmark
    public int parseStringToIntReflectionGetChars() throws IllegalAccessException {
        return convertStringToIntReflectionGetChars(toParse);
    }

    @Benchmark
    public int parseStringToIntLuxoftChars() {
        return convertStringToIntLuxoftChars(toParseChars);
    }

    @Benchmark
    public int parseStringToIntStackOverflow() {
        return intValueOfStackOverflow(toParse);
    }

    @Benchmark
    public int parseStringToIntUsingSwitch() {
        return convertStringToIntUsingSwitch(toParse);
    }

    @Benchmark
    public int parseStringToIntUtf8Bytes() {
        return convertStringToIntUtf8Bytes(toParseUtf8);
    }

    @Benchmark
    public int parseStringToIntUtf8Bytes2() {
        return convertStringToIntUtf8Bytes2(toParseUtf8);
    }

    @Benchmark
    public int parseStringToIntUtf16Bytes() {
        return convertStringToIntUtf8Bytes(toParseUtf16);
    }

    @Benchmark
    public int parseStringToIntUtf16Bytes2() {
        return convertStringToIntUtf8Bytes(toParse.getBytes(StandardCharsets.UTF_16));
    }

    @Benchmark
    public int parseStringToIntStringToUtf8Bytes() {
        return convertStringToIntUtf8Bytes(toParse.getBytes(StandardCharsets.UTF_8));
    }

    public static int convertStringToIntLuxoft(String num) {
        int result = 0;
        final int zeroAscii = 48;
        final int nineAscii = 57;
        for (char c : num.toCharArray()) {
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
            char c = num.charAt(i);
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
        for (char c : (char[]) STRING_VALUE_FIELD.get(num)) {
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
        for (char c : num) {
            if (c >= zeroAscii && c <= nineAscii) {
                result = result * 10 + (c - zeroAscii);
            } else
                return -1;
        }
        return result;
    }

    public static int convertStringToIntUsingSwitch(String num) {
        int result = 0;
        for (char c : num.toCharArray()) {
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

    public static int convertStringToIntUtf8Bytes(byte[] num) {
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

    public static int convertStringToIntUtf8Bytes2(byte[] num) {
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
