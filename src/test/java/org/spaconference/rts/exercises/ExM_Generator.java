package org.spaconference.rts.exercises;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spaconference.rts.runner.ExampleRunner;
import org.spaconference.rts.runner.ExampleRunner.Way;


@RunWith(ExampleRunner.class)
public class ExM_Generator {

	@Way
    public static List<Integer> newWay(int count) {
        return null;
    }
	
    @Way
    public static List<Integer> oldWay(int count) {
        List<Integer> result = new ArrayList<>();
        int i1 = 1;
        int i2 = 2;

        for (int i = 0; i < count; i++) {
            int t = i1;
            i1 = i2;
            i2 = t + i2;
            result.add(t);
        }
        return result;
    }

    @Test
    public void test(IntFunction<List<Integer>> f) {
        assertThat(f.apply(10), equalTo(asList(1, 2, 3, 5, 8, 13, 21, 34, 55, 89)));
    }

}
