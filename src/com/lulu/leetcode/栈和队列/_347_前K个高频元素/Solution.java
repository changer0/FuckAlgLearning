package com.lulu.leetcode.栈和队列._347_前K个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
class Solution {

    static class Node {
        int freq;
        int value;
        public Node(int freq, int value) {
            this.freq = freq;
            this.value = value;
        }
    }

    //使用 map 保存对应频率
    //使用 PriorityQueue 获取前 K 高的元素
    public int[] topKFrequent(int[] nums, int k) {
        //保存频率
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        //将 freq 中的值取出来 保存到优先队列中
        PriorityQueue<Node> q = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n2.freq - n1.freq;
            }
        });
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            q.offer(new Node(entry.getValue(), entry.getKey()));
        }
        int[] res = new int[k];
        //从 q 中取出前 k 个对应的元素
        for (int i = 0; i < k; i++ ) {
            Node node = q.poll();
            res[i] = node.value;
        }
        return res;
    }
}
