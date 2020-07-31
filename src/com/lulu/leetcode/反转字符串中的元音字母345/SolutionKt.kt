package com.lulu.leetcode.反转字符串中的元音字母345

import kotlin.test.assertFailsWith


/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 输入: "hello"
 * 输出: "holle"
 *
 * A、E、I、O、U通常都是元音字母
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().reverseVowels("leetcode"))
        }
    }

    /**
     * 指针对撞
     */
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()
        var l = 0; var r = chars.size-1
        while (l <= r) {
            if (!isVowel(chars[l])) {
                l++
            } else if (!isVowel(chars[r])) {
                r--
            } else {
                swap(chars, l++ ,r--)
            }

        }

        return String(chars)
    }

    /**
     * 是否为元音 A、E、I、O、U
     */
    private fun isVowel(c: Char): Boolean{
        if (c.equals('a', true)
            || c.equals('e', true)
            || c.equals('i', true)
            || c.equals('o', true)
            || c.equals('u', true) ) {
            return true
        }
        return false
    }


    /**
     * Swaps x[a] with x[b].
     */
    private fun swap(x: CharArray, a: Int, b: Int) {
        val t = x[a]
        x[a] = x[b]
        x[b] = t
    }
}
