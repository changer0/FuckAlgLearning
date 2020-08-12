package com.lulu.leetcode.递归回溯法._17_电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 经典回溯问题，需要多加练习
 */
class Solution {
    //数字与字母的对应
    private String[] lettersMap = {
            " ",//0
            "",//1
            "abc",//2
            "def",//3
            "ghi",//4
            "jkl",//5
            "mno",//6
            "pqrs",//7
            "tuv",//8
            "wxyz",//9
    };
    private List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        res.clear();
        if (digits == null || digits.isEmpty()) return res;
        letterCombinations(digits, 0, "");
        return res;
    }
    //index: 表示当前递归的 index s: 表示拼接的字母
    private void letterCombinations(String digits, int index, String s) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        char c = digits.charAt(index);
        assert c != '1' && c <= '9' && c >= '0';
        String letters = lettersMap[c - '0'];//获取当前数字对应的字母
        for (int i = 0; i < letters.length(); i++) {
            letterCombinations(digits, index+1, s + letters.charAt(i));
        }
    }
}
