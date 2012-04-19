package com.github.larsmoil.reader;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/19/12
 *         Time: 10:39 PM
 */
public class ExampleItemReaderTest {

    private ExampleItemReader exampleItemReader;

    @BeforeTest
    public void setUp() {
        exampleItemReader = new ExampleItemReader();
    }

    @Test
    public void testRead() throws Exception {
        int i;
        for (i = 0; exampleItemReader.read() != null; i++) {

        }
        assertEquals(1000, i);
    }
}
