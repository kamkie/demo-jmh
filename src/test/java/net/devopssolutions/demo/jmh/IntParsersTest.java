package net.devopssolutions.demo.jmh;

import org.assertj.core.api.Assertions;
import org.junit.Assume;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IntParsersTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", 0}, {"1", 1}, {"2", 2}, {"3", 3}, {"989819", 989819}, {"98989", 98989},
        });
    }

    private String input;
    private int expected;

    public IntParsersTest(String input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Test
    public void convertStringToIntLuxoft() {
        int actual = IntParsers.convertStringToIntLuxoft(input);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntLuxoftFori() {
        int actual = IntParsers.convertStringToIntLuxoftFori(input);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntLuxoftFori2() {
        int actual = IntParsers.convertStringToIntLuxoftFori2(input);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntReflectionGetCharsJdk8() throws IllegalAccessException {
        Assume.assumeTrue(System.getProperty("java.version"), System.getProperty("java.version").startsWith("1."));

        int actual = IntParsers.convertStringToIntReflectionGetCharsJdk8(input);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntReflectionGetCharsJdk9() throws IllegalAccessException {
        Assume.assumeTrue(System.getProperty("java.version"), System.getProperty("java.version").startsWith("9"));

        int actual = IntParsers.convertStringToIntReflectionGetCharsJdk9(input);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntLuxoftChars() {
        int actual = IntParsers.convertStringToIntLuxoftChars(input.toCharArray());
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntLuxoftChars2() {
        int actual = IntParsers.convertStringToIntLuxoftChars2(input.toCharArray());
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntLuxoftChars3() {
        int actual = IntParsers.convertStringToIntLuxoftChars3(input.toCharArray());
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntUsingSwitch() {
        int actual = IntParsers.convertStringToIntUsingSwitch(input);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntFromBytes() {
        int actual = IntParsers.convertStringToIntFromBytes(input.getBytes(StandardCharsets.UTF_8));
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntFromBytesUtf16() {
        int actual = IntParsers.convertStringToIntFromBytesUtf16(input.getBytes(StandardCharsets.UTF_16));
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntFromBytes2Utf16() {
        int actual = IntParsers.convertStringToIntFromBytes2Utf16(input.getBytes(StandardCharsets.UTF_16));
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntFromBytes3Utf16() {
        int actual = IntParsers.convertStringToIntFromBytes3Utf16(input.getBytes(StandardCharsets.UTF_16));
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntFromBytes2() {
        int actual = IntParsers.convertStringToIntFromBytes2(input.getBytes(StandardCharsets.UTF_8));
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void convertStringToIntFromBytes3() {
        int actual = IntParsers.convertStringToIntFromBytes3(input.getBytes(StandardCharsets.UTF_8));
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

    @Test
    public void intValueOfStackOverflow() {
        int actual = IntParsers.intValueOfStackOverflow(input);
        Assertions.assertThat(actual)
                .isEqualTo(expected);
    }

}
