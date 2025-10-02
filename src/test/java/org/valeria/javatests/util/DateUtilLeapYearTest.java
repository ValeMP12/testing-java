package org.valeria.javatests.util;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class DateUtilLeapYearTest {
    @Test
    public void returnTrueWhenYearIsDivisibleBy400() {
        assertThat(DateUtil.isLeapYear(1600), is(true));
        assertThat(DateUtil.isLeapYear(2000), is(true));
        assertThat(DateUtil.isLeapYear(2400), is(true));
    }
    @Test
    public void returnFalseWhenYearIsDivisibleBy100ButNotBy400() {
        assertThat(DateUtil.isLeapYear(1700), is(false));
        assertThat(DateUtil.isLeapYear(1800), is(false));
        assertThat(DateUtil.isLeapYear(1900), is(false));
    }

    @Test
    public void returnTrueWhenYearIsDivisibleBy4ButNotBy100() {
        assertThat(DateUtil.isLeapYear(1996), is(true));
        assertThat(DateUtil.isLeapYear(2004), is(true));
        assertThat(DateUtil.isLeapYear(2008), is(true));
    }
    @Test
    public void returnFalseWhenYearIsDivisibleBy4() {
        assertThat(DateUtil.isLeapYear(2017), is(false));
        assertThat(DateUtil.isLeapYear(2018), is(false));
        assertThat(DateUtil.isLeapYear(2019), is(false));
    }
}