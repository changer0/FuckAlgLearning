package com.lulu.leetcode.贪心算法._316_去除重复字母;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
    public static String removeDuplicateLetters(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        //记录字符最后出现的位置
        int[] lastAppearIndex = new int[26];
        for (int i = 0; i < len; i++) {
            //从头开始遍历,找到每个字符出现的最后位置
            lastAppearIndex[chars[i] - 'a'] = i;
        }
        //用于记录栈中被访问过的字符
        boolean[] visited = new boolean[26];
        //构造一个栈用于处理字符串
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            if (visited[chars[i] - 'a']) {
                //如果当前字符已经在栈中了,就忽略
                continue;
            }
            // 当前栈不为空
            // 且 栈顶字符顺序 > 当前顺序
            // 且 栈顶字符在当前位置之后也出现过
            // 此时需要出栈
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && lastAppearIndex[stack.peekLast() - 'a'] > i) {
                Character top = stack.removeLast();
                visited[top - 'a'] = false;
            }
            //入栈
            stack.addLast(chars[i]);
            //标识当前已经被访问过
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        for (Character character : stack) {
            builder.append(character);
        }
        return builder.toString();
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
