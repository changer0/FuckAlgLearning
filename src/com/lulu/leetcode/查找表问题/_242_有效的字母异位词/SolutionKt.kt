package com.lulu.leetcode.查找表问题._242_有效的字母异位词


/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().isAnagram("anagram", "nagaram"))
            println(SolutionKt().isAnagram2("anagram", "nagaram"))
        }
    }

    /**
     * 是否为异位词
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length ) {
            return false
        }
        //记录 s 的字母出现频率
        val sFreqMap = hashMapOf<Char, Int>()
        for (c in s) {
            val freq = sFreqMap[c]
            if (freq == null) {
                sFreqMap[c] = 1
            } else {
                sFreqMap[c] = freq+1
            }
        }
        //记录 t 的字母出现频率
        val tFreqMap = hashMapOf<Char, Int>()
        for (c in t) {
            val freq = tFreqMap[c]
            if (freq == null) {
                tFreqMap[c] = 1
            } else {
                tFreqMap[c] = freq+1
            }
        }

        //比较两个频率
        for (sEntry in sFreqMap) {
            if (tFreqMap[sEntry.key] != sEntry.value) {
                return false
            }
        }
        return true
    }

    /**
     * 是否为异位词 数组版 题目要求只为小写字母
     */
    fun isAnagram2(s: String, t: String): Boolean {
        if (s.length != t.length ) {
            return false
        }
        //记录 s 的字母出现频率
        val sFreqMap = IntArray(128)
        for (c in s) {
            sFreqMap[c.toInt()] ++
        }
        //记录 t 的字母出现频率
        val tFreqMap = IntArray(128)
        for (c in t) {
            tFreqMap[c.toInt()] ++
        }

        //比较两个频率
        for (i in 0 until sFreqMap.size) {
            if (sFreqMap[i] != tFreqMap[i]) {
                return false
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
