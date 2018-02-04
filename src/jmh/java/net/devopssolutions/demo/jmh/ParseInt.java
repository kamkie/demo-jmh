package net.devopssolutions.demo.jmh;

import org.openjdk.jmh.annotations.*;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

import static net.devopssolutions.demo.jmh.IntParsers.*;

@Warmup(timeUnit = TimeUnit.MILLISECONDS, time = 100, iterations = 5)
@Measurement(timeUnit = TimeUnit.MILLISECONDS, time = 200, iterations = 5)
@Threads(1)
@Fork(1)
public class ParseInt {


    @State(Scope.Thread)
    public static class StateStringToParse {
        @Param({"989819", "98989", "1", "2", "3257"})
        String toParse;
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
    public int parseStringToIntReflectionGetCharsJdk8(StateStringToParse state) throws IllegalAccessException {
        return convertStringToIntReflectionGetCharsJdk8(state.toParse);
    }

    @Benchmark
    public int parseStringToIntReflectionGetCharsJdk9(StateStringToParse state) throws IllegalAccessException {
        return convertStringToIntReflectionGetCharsJdk9(state.toParse);
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
        return convertStringToIntFromBytesUtf16(state.toParseUtf16);
    }

    @Benchmark
    public int parseStringToIntUtf16Bytes2(StateStringToParse state) {
        return convertStringToIntFromBytes2Utf16(state.toParseUtf16);
    }

    @Benchmark
    public int parseStringToIntUtf16Bytes3(StateStringToParse state) {
        return convertStringToIntFromBytes3Utf16(state.toParseUtf16);
    }

    @Benchmark
    public int parseStringToIntStringToUtf16Bytes(StateStringToParse state) {
        return convertStringToIntFromBytesUtf16(state.toParse.getBytes(StandardCharsets.UTF_16));
    }

    @Benchmark
    public int parseStringToIntStringToUtf8Bytes(StateStringToParse state) {
        return convertStringToIntFromBytes(state.toParse.getBytes(StandardCharsets.UTF_8));
    }

}
