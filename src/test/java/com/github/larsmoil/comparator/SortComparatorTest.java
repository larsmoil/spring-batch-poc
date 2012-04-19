package com.github.larsmoil.comparator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/19/12
 *         Time: 10:24 PM
 */
public class SortComparatorTest {

    private SortComparator sortComparator;

    @BeforeTest
    public void setUp() {
        sortComparator = new SortComparator();
    }

    @Test
    public void testCompare() {
        assertEquals(0, sortComparator.compare("1234567", "12345--"));
        assertTrue(sortComparator.compare("12344", "12345--") < 0);
        assertTrue(sortComparator.compare("12345", "12344--") > 0);
    }

    @Test(expectedExceptions = StringIndexOutOfBoundsException.class, expectedExceptionsMessageRegExp = ".*\\W5$")
    public void testRequiresStringOfFiveCharactersInFirstString() {
        sortComparator.compare("1234", "12345");
    }

    @Test(expectedExceptions = StringIndexOutOfBoundsException.class, expectedExceptionsMessageRegExp = ".*\\W5$")
    public void testRequiresStringOfFiveCharactersInSecondString() {
        sortComparator.compare("12345", "1234");
    }
}
