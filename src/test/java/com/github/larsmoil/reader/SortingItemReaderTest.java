package com.github.larsmoil.reader;

import com.github.larsmoil.comparator.SortComparator;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import static org.testng.Assert.assertEquals;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/19/12
 *         Time: 10:42 PM
 */
public class SortingItemReaderTest {

    private SortingItemReader<String> sortingItemReader;

    @BeforeTest
    public void setUp() throws Exception {
        ItemReader<String> itemReader = new ItemReader<String>() {

            private final List<String> items = new LinkedList<String>(Arrays.asList("3----", "2----", "1----"));

            @Override
            public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                return items.isEmpty() ? null : items.remove(0);
            }
        };
        sortingItemReader = new SortingItemReader<String>(itemReader, new SortComparator());
    }

    @Test
    public void testSorts() throws Exception {
        List<String> items = new LinkedList<String>();
        for (String item; (item = sortingItemReader.read()) != null; ) {
            items.add(item);
        }
        assertEquals(new TreeSet<String>(items), items);
    }

}
