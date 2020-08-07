package com.lulu.leetcode.栈和队列._20_有效的括号;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution {
    //需要多考虑几种场景，"]" "["
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()) {
                return false;
            }
            if(stack.pop() != getMatchChar(c)) {
                return false;
            }
        }
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    private char getMatchChar(char c) {
        if (c == ')')
            return '(';
        if (c == '}')
            return '{';
        if (c == ']')
            return '[';

        return ' ';
    }
}
