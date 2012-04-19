package com.github.larsmoil.comparator;

import java.util.Comparator;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/19/12
 *         Time: 6:10 PM
 */
public class SortComparator implements Comparator<String> {

    @Override
    public int compare(String s, String s1) {
        return s.substring(0, 5).compareTo(s1.substring(0, 5));
    }
}
