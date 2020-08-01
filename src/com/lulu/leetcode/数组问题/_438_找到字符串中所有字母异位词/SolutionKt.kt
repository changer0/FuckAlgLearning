package com.lulu.leetcode.数组问题._438_找到字符串中所有字母异位词


/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().findAnagrams("cbaebabacd", "abc"))
            println(SolutionKt().findAnagrams("", "a"))
            println(SolutionKt().findAnagrams("baa", "aa"))
        }
    }

    /**
        输入:
        s: "abab" p: "ab"

        输出:
        [0, 1, 2]

        解释:
        起始索引等于 z 0 的子串是 "ab", 它是 "ab" 的字母异位词。
        起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
        起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     */
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) {
            return listOf()
        }
        var l = 0; var r = p.length-1 //滑动窗口：[l, r]

        val resList: MutableList<Int> = mutableListOf()
        val freq = IntArray(26)
        for (i in 0 until p.length) {
            freq[getFreqIndex(p[i])] ++
        }
        val floatFreq = IntArray(26)//滑块的出现频率
        // 首次初始化
        for (i in l .. r) {
            floatFreq[getFreqIndex(s[i])] ++
        }
        while (r < s.length) {
            //检查当前滑块是否为字母异位词
            var temp = true
            for (i in 0 until 26) {
                if (freq[i] != floatFreq[i]) {
                    temp = false
                }
            }
            if(temp) {
                resList.add(l)
            }
            if (r+1 < s.length) {
                floatFreq[getFreqIndex(s[l])]--
                floatFreq[getFreqIndex(s[r+1])]++
            }
            l++
            r++
        }

        return resList
    }


    private fun getFreqIndex(char: Char): Int {
        return char.toInt() - 'a'.toInt()
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
