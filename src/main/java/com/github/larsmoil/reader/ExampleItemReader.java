package com.github.larsmoil.reader;

import org.springframework.batch.item.ItemReader;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/17/12
 *         Time: 8:32 PM
 */
public class ExampleItemReader implements ItemReader<String> {

    private final LinkedList<String> items = new LinkedList<String>();

    public ExampleItemReader() {
        for (int i = 0; i < 1000; i++) {
            items.add(String.format("%05d, %d", i, new Random().nextInt()));
        }
    }

    @Override
    public String read() throws Exception {
        synchronized (items) {
            return items.poll();
        }
    }
}
