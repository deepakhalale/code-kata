package com.ihsmarkit.code.kata;

import static com.ihsmarkit.code.kata.CommonDenominators.convertFracs;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Test;

public class CommonDenominatorsTest {

    @Test
    public void shouldApplyLeastCommonDenominatorToInput1() {
        final String result = convertFracs(new long[][]{{1, 4}, {1, 2}, {1, 3}});

        assertThat(result, is("(3,12)(6,12)(4,12)"));
    }

    @Test
    public void shouldApplyLeastCommonDenominatorToInput2() {
        final String result = convertFracs(new long[][]{{1, 8}, {2, 13}});

        assertThat(result, is("(13,104)(16,104)"));
    }

    @Test
    public void shouldApplyLeastCommonDenominatorToInput3() {
        final String result = convertFracs(new long[][]{{1, 5}, {0, 1}, {1, 2}, {1, 3}, {1, 4}});

        assertThat(result, is("(12,60)(0,60)(30,60)(20,60)(15,60)"));
    }

    @Test
    public void shouldApplyLeastCommonDenominatorToInput4() {
        final String result = convertFracs(new long[][]{{1, 4}, {1, 2}, {1, 8}});

        assertThat(result, is("(2,8)(4,8)(1,8)"));
    }

}
