package org.anz.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    @Test
    public void test1() {
        List<String> input = new ArrayList<>();
        input.add("a.o:a.c, b.o:b.c, c.o:c.c, p1:a.o, p1:b.o, p2:b.o, p2:c.o");
        input.add("b.c");
        Assert.assertEquals("b.o, p1, p2", Solution.showChanges(input));
    }
}
