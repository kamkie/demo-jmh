package net.devopssolutions.demo.jmh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParseIntTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", 0}, {"1", 1}, {"2", 2}, {"3", 3}, {"989819", 989819}, {"98989", 98989},
        });
    }

    private ParseInt.StateStringToParse input;
    private int expected;
    private ParseInt parseInt;

    public ParseIntTest(String input, int expected) {
        this.input = new ParseInt.StateStringToParse(input);
        this.expected = expected;
        parseInt = new ParseInt();
    }


    @Test
    public void testParseStringToIntIntegerParseInt() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntIntegerParseInt(input));
    }

    @Test
    public void testParseStringToIntLuxoft() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntLuxoft(input));
    }

    @Test
    public void testParseStringToIntLuxoftFori() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntLuxoftFori(input));
    }

    @Test
    public void testParseStringToIntLuxoftFori2() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntLuxoftFori2(input));
    }

    @Test
    public void testParseStringToIntReflectionGetChars() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntReflectionGetChars(input));
    }

    @Test
    public void testParseStringToIntLuxoftChars() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntLuxoftChars(input));
    }

    @Test
    public void testParseStringToIntLuxoftChars2() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntLuxoftChars2(input));
    }

    @Test
    public void testParseStringToIntLuxoftChars3() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntLuxoftChars3(input));
    }

    @Test
    public void testParseStringToIntStackOverflow() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntStackOverflow(input));
    }

    @Test
    public void testParseStringToIntUsingSwitch() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntUsingSwitch(input));
    }

    @Test
    public void testParseStringToIntUtf8Bytes() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntUtf8Bytes(input));
    }

    @Test
    public void testParseStringToIntUtf8Bytes2() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntUtf8Bytes2(input));
    }

    @Test
    public void testParseStringToIntUtf8Bytes3() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntUtf8Bytes3(input));
    }

    @Test
    public void testParseStringToIntUtf16Bytes() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntUtf16Bytes(input));
    }

    @Test
    public void testParseStringToIntUtf16Bytes2() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntUtf16Bytes2(input));
    }

    @Test
    public void testParseStringToIntUtf16Bytes3() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntUtf16Bytes3(input));
    }

    @Test
    public void testParseStringToIntStringToUtf16Bytes() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntStringToUtf16Bytes(input));
    }

    @Test
    public void testParseStringToIntStringToUtf8Bytes() throws Exception {
        assertEquals(expected, parseInt.parseStringToIntStringToUtf8Bytes(input));
    }
}
