package com.lulu.leetcode.数组问题._76_最小覆盖子串


/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //println(SolutionKt().minWindow("ADOBECODEBANC", "ABC"))
            //println(SolutionKt().minWindow2("ADOBECODEBANC", "ABC"))
            println(SolutionKt().minWindow2("aab", "aab"))
        }
    }


    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     */
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) {
            return ""
        }
        var l = 0; var r = -1 //滑动窗口：[l, r]
        val winFreq = IntArray(256)//滑块的出现频率
        val targetFreq = IntArray(256)//目标字符串出现频率
        //初始化 targetFreq
        for (i in 0 until t.length) {
            targetFreq[t[i].toInt()]++
        }
        var minSubLength = s.length + 1
        var mL = -1
        var mR = -1
        while (r+1 < s.length) {
            winFreq[s[r+1].toInt()] ++
            if (isMatch(winFreq, targetFreq, t)) {
                if (minSubLength > r - l + 1) {
                    mL = l
                    mR = r+1
                }
                minSubLength = Math.min(minSubLength, r-l+1)
                winFreq[s[l++].toInt()] --
                winFreq[s[r+1].toInt()] --
            } else {
                r++
            }

        }
        if (mL < 0 || mR < 0) {
            return ""
        }

        return s.substring(mL, mR+1)
    }

    /**
     * winFreq 中 t 的字符频数可以大于 targetFreq 的频数
     */
    private fun isMatch(winFreq: IntArray, targetFrq: IntArray, t: String): Boolean{
        for (i in 0 until t.length) {
            if (winFreq[t[i].toInt()] < targetFrq[t[i].toInt()]) {//关键在于这个位置不是 != 而是 <
                return false
            }
        }
        return true
    }

    //------------------------------------------------------------------------------------------------------------------
    // 优化解法
    /**
     * 利用 distance 变量实现判断字串在滑块中有无
     */
    fun minWindow2(s: String, t: String): String {
        var l = 0; var r = -1 //滑动窗口：[l, r]
        val winFreq = IntArray(256)//窗口字符串出现频率
        val targetFreq = IntArray(256)//目标字符串出现频率
        //初始化 targetFreq
        for (i in 0 until t.length) {
            targetFreq[t[i].toInt()]++
        }
        var distance = 0 //用来保存窗口内匹配到 t 中字符频数的长度
        var minLength = s.length+1 //保存最短长度
        var minBegin = 0 //保存最短长度的开始位置
        while (r+1 < s.length) {
            if (targetFreq[s[r+1].toInt()] == 0) { //该字符串不在 t 中，忽略
                r++
                continue
            }
            r++//++ 后 r 指向的是包含 t 的字符
            if (winFreq[s[r].toInt()] < targetFreq[s[r].toInt()]) {
                distance++
            }
            winFreq[s[r].toInt()]++

            //长度与 t 相同，说明已经包含了所有的 t 中的字符
            while (distance == t.length) { //需要检查让 l 移动，条件就是长度不满足 t 的长度
                if (targetFreq[s[l].toInt()] == 0) { //该字符串不在 t 中，忽略
                    l++
                    continue
                }
                if (minLength > r - l + 1) {
                    minLength = r - l + 1
                    minBegin = l
                }
                if (winFreq[s[l].toInt()] == targetFreq[s[l].toInt()]) {
                    distance--
                }
                winFreq[s[l].toInt()]--
                l++
            }
        }
        //非法判断
        if (minLength == s.length + 1) {
            return ""
        }

        return s.substring(minBegin, minBegin+minLength)
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
