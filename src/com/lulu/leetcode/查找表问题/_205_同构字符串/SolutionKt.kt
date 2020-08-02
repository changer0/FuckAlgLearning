package com.lulu.leetcode.查找表问题._205_同构字符串


/**
 * https://leetcode-cn.com/problems/isomorphic-strings/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().isIsomorphic("egg", "add"))
            println(SolutionKt().isIsomorphic("foo", "bar"))
            println(SolutionKt().isIsomorphic("paper", "title"))
        }
    }

    /**
     * 输入: s = "egg", t = "add"
     * 输出: true
     */
    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val map = hashMapOf<Char, Char>()
        for (i in 0 until s.length) {
            val c = map[s[i]]
            if (c == null) {
                if (map.containsValue(t[i])) {
                    return false
                }
                map[s[i]] = t[i]
            } else {
                if (c != t[i]) {
                    return false
                }
            }
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
