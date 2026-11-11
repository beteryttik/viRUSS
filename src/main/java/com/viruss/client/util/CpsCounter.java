package com.viruss.client.util;

import java.util.ArrayDeque;
import java.util.Deque;

public class CpsCounter {
    private static final Deque<Long> clicks = new ArrayDeque<>();

    public static void click() {
        long now = System.currentTimeMillis();
        clicks.addLast(now);
    }

    public static int getCps() {
        long cutoff = System.currentTimeMillis() - 1000;
        while (!clicks.isEmpty() && clicks.peekFirst() < cutoff) clicks.pollFirst();
        return clicks.size();
    }
}
