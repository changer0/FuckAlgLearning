package com.lulu.leetcode.数组问题._3_无重复字符的最长子串


/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().lengthOfLongestSubstring("abcabcbb"))
        }
    }

    /**
     * 滑动窗口解决
     */
    fun lengthOfLongestSubstring(s: String): Int {
        var l = 0; var r = -1 //窗口定义：[l, r]
        var maxSubLength = 0 //最长字串长度确定
        var freq = IntArray(256) //所有 ascii 码出现频率
        while (l < s.length) {
            //检查当前元素是否包含在滑块内
            if (r+1 < s.length && freq[s[r+1].toInt()] == 0) {
                freq[s[++r].toInt()]++ //此时出现频率 ++
            } else {
                freq[s[l++].toInt()]-- //此时需要将该出现频率 --，且需要将左边界向右移动
            }
            //上面已经保证每次滑块都不会出现重复的字符串
            maxSubLength = Math.max(maxSubLength, r-l+1)
        }
        return maxSubLength
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
