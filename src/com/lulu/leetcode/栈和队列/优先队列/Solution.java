package com.lulu.leetcode.栈和队列.优先队列;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 优先队列
 */
public class Solution {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        queue.offer(4);
        queue.offer(2);
        queue.offer(5);
        queue.offer(1);
        queue.offer(7);

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
//
//        Map<Integer, Integer> map = new HashMap<>();
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
//            integerIntegerEntry.getValue();
//            integerIntegerEntry.getKey();
//        }
//        map.put()
    }



}
