package com.github.larsmoil.processor;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/19/12
 *         Time: 10:34 PM
 */
public class SlowItemProcessorTest {

    private SlowItemProcessor slowItemProcessor;

    @BeforeTest
    public void setUp() {
        slowItemProcessor = new SlowItemProcessor();
    }

    @Test
    public void testProcessReturnsSameObject() throws Exception {
        String s = "s";
        assertTrue(s == slowItemProcessor.process(s));
    }
}
