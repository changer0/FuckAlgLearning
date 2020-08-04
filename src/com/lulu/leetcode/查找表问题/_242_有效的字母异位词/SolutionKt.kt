package com.lulu.leetcode.查找表问题._242_有效的字母异位词


/**
 * https://leetcode-cn.com/problems/valid-anagram/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().isAnagram("anagram", "nagaram"))
            println(SolutionKt().isAnagram("a", "b"))
        }
    }


    /**
     * 质数法 对26个字母分别赋予对应的质数值，因为不同的质数和必定为不同的数字结果，所以可以用来作为map的key值
     *
     * 字符串超长并不适用
     */
    fun isAnagram(s: String, t: String): Boolean {
        val a = doubleArrayOf(2.0,3.0,5.0,7.0,11.0,13.0,17.0,19.0,23.0,29.0,
            31.0,37.0,41.0,43.0,47.0,53.0,59.0,61.0,67.0,71.0,
            73.0,79.0,83.0,89.0,97.0,101.0)
        var sK = 1.0; var tK = 1.0
        for (c in s) {
            sK *= a[c.toInt() - 'a'.toInt()]
        }
        for (c in t) {
            tK *= a[c.toInt() - 'a'.toInt()]
        }
        if (sK == tK) {
            return true
        }
        return false
    }
    /**
     * 排序法
     */
    fun isAnagram3(s: String, t: String): Boolean {
        val lStrArr = s.toByteArray()
        val rStrArr = t.toByteArray()
        lStrArr.sort()
        rStrArr.sort()
        if (String(lStrArr) == String(rStrArr)) {
            return true
        }
        return false
    }
    /**
     * 使用 Hash 计算频率
     */
    fun isAnagram2(s: String, t: String): Boolean {
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
    fun isAnagram1(s: String, t: String): Boolean {
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


}
