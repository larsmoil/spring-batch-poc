package com.github.larsmoil.reader;

import org.springframework.batch.item.ItemReader;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/19/12
 *         Time: 5:58 PM
 */
public class SortingItemReader<T> implements ItemReader<T> {

    private final ItemReader<T> delegate;
    private final Comparator<T> comparator;
    private final LinkedList<T> items;
    private boolean initialized;

    public SortingItemReader(final ItemReader<T> delegate, final Comparator<T> comparator) {
        this.delegate = delegate;
        this.comparator = comparator;
        items = new LinkedList<T>();
    }

    @Override
    public T read() throws Exception {
        if (!initialized) {
            initialize();
        }
        return items.poll();
    }

    private void initialize() throws Exception {
        T item;
        while ((item = delegate.read()) != null) {
            items.add(item);
        }
        Collections.sort(items, comparator);
        initialized = true;
    }
}
