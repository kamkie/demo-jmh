package net.devopssolutions.demo.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collections {

    public static final int LIST_SIZE = 1_000_000;
    public static final int LIST_SIZE_DIV_2 = LIST_SIZE / 2;
    public static final int NUMBER_OF_ADDITIONS = 100;
    public static final TimeValue TEST_TIME = TimeValue.milliseconds(1000);
    public static final int MEASUREMENT_ITERATIONS = 5;
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


    @State(Scope.Benchmark)
    public static class StateArrayList {

        List<Integer> list;

        @Setup(Level.Iteration)
        public void init() {
            list = new ArrayList<>(LIST_SIZE);
            for (int i = 0; i < LIST_SIZE; i++) {
                list.add(i);
            }
        }

        @TearDown(Level.Iteration)
        public void end() {
            list.clear();
            list = null;
        }
    }

    @State(Scope.Benchmark)
    public static class StateLinkedList {

        List<Integer> list;

        @Setup(Level.Iteration)
        public void init() {
            list = new LinkedList<>();
            for (int i = 0; i < LIST_SIZE; i++) {
                list.add(i);
            }
        }

        @TearDown(Level.Iteration)
        public void end() {
            list.clear();
            list = null;
        }
    }

    //    @Benchmark
    public void addLinkedList(StateLinkedList state) {
        for (int i = 0; i < NUMBER_OF_ADDITIONS; i++) {
            state.list.add(LIST_SIZE_DIV_2, -999);
        }
    }

    //    @Benchmark
    public void addArrayList(StateArrayList state) {
        for (int i = 0; i < NUMBER_OF_ADDITIONS; i++) {
            state.list.add(LIST_SIZE_DIV_2, -999);
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

    public static void main(String[] args) throws RunnerException {
//        byte abc = unsafe.getByte("abc", 0L);
//        System.out.println(abc);

        System.out.println("utf8 bytes: " + toParseUtf8.length);
        System.out.println("utf16 bytes: " + toParseUtf16.length);

        Options opt = new OptionsBuilder()
                .include(".*" + Collections.class.getSimpleName() + ".*")
                .mode(Mode.Throughput)
                .warmupTime(TEST_TIME)
                .warmupIterations(MEASUREMENT_ITERATIONS)
                .measurementIterations(MEASUREMENT_ITERATIONS)
                .measurementTime(TEST_TIME)
                .threads(1)
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}
