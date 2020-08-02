package com.lulu.leetcode.查找表问题._290_单词规律


/**
 * https://leetcode-cn.com/problems/word-pattern/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().wordPattern("abba", "dog cat cat dog"))
            println(SolutionKt().wordPattern("abba", "dog cat cat fish"))
            println(SolutionKt().wordPattern("abba", "dog dog dog dog"))
            println(SolutionKt().wordPattern("aaa", "aa aa aa aa"))
            println(SolutionKt().wordPattern("jquery", "jquery"))
        }
    }

    /**
     * 输入: pattern = "abba", str = "dog cat cat dog"
     * 输出: true
     *
     * 需要考虑几种场景：
     * 1. pattern 中与 str 中的单词对应，包括是否一个 pattern 对应多个单词，多个 pattern 对应一个单词
     * 2. pattern 的长度与单词个数是否匹配
     */
    fun wordPattern(pattern: String, str: String): Boolean {
        var l = 0; var r = -1 //[l, r] 表示 str 中的一个单词
        val map = hashMapOf<Char, String>()//用于保存对应关系
        var pIndex = 0//模式制定游标
        while (r < str.length) {
            if ((r+1 < str.length && str[r+1].isWhitespace()) || r == str.length-1) {

                if (pIndex >= pattern.length) {
                    return false
                }
                val p1 = map[pattern[pIndex]]
                val subStr = str.substring(l, r + 1)
                if (p1 == null) {
                    if (map.containsValue(subStr)) {// 从 map 中找到的 key 为空，但是 map 的 value 又有对应的单词，有冲突
                        return false
                    } else {
                        map[pattern[pIndex]] = subStr
                    }
                } else if (p1 != subStr) {// 从 map 中取出的单词与字串不符，有冲突
                    return false
                }
                l = r+2
                pIndex++
            }
            r++
        }
        if (pIndex != pattern.length) {//模式长度与单词个数不符
            return false
        }
        return true
    }

    /**
     * Swaps x[a] with x[b].
     */
    private fun swap(x: IntArray, a: Int, b: Int) {
        val t = x[a]
        x[a] = x[b]
        x[b] = t
    }

}
