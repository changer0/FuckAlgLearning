package com.lulu.leetcode.数组问题._125_验证回文串


/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().isPalindrome("A man, a plan, a canal: Panama"))
            println(SolutionKt().isPalindrome("race a car"))
            println(SolutionKt().isPalindrome("0P"))
            println(SolutionKt().isPalindrome(""))
            println(SolutionKt().isPalindrome(" "))
            println(SolutionKt().isPalindrome("P"))
            println(SolutionKt().isPalindrome("."))
        }
    }


    fun isPalindrome(s: String): Boolean {
        val chars = s.trim().toCharArray()
        var l = 0; var r = chars.size-1 //[l, r]

        while (l < r) {
            if (!isAbc(chars[l])) {
                l++
                continue
            }
            if (!isAbc(chars[r])) {
                r--
                continue
            }
            if (chars[l].equals(chars[r], true)) {
                l++; r--
            } else {
                return false
            }
        }
        return true
    }

    fun isAbc(a: Char): Boolean {
        if ((a in 'a'..'z') || (a in 'A'..'Z') || (a in '0'..'9')) {
            return true
        }
        return false
    }

}
