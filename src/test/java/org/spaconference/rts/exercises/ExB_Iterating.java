package org.spaconference.rts.exercises;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spaconference.rts.runner.ExampleRunner;
import org.spaconference.rts.runner.ExampleRunner.Way;

@RunWith(ExampleRunner.class)
public class ExB_Iterating {

	// hint: StreamSupport
	@Way
    public static void newWay(Iterable<String> things, PrintWriter writer) throws IOException {
        
    }
	
    @Way
    public static void oldWay(Iterable<String> things, PrintWriter writer) throws IOException {
        for (String thing : things) {
            writer.write(thing);
        }
    }

    @Test
    public void test(Thing f) {
        Writer writer = new StringWriter();
        f.call(asList("one", "two", "three"), writer);
        assertThat(writer.toString(), equalTo("onetwothree"));
    }

    public interface Thing {
        public void call(Iterable<String> things, Writer writer);
    }
}