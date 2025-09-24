package org.valeria.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
    @Test
    public void testRepeat() {
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }
    @Test
    public void repeat_string_multiple_times() {
        Assert.assertEquals("abcabcabc", StringUtil.repeat("abc", 3));
    }
    @Test
    public void repeat_string_zero_times() {
        Assert.assertEquals("", StringUtil.repeat("abc", 0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
        StringUtil.repeat("abc", -1);
    }
}