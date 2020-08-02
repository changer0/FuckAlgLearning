package com.lulu.leetcode.查找表问题._202_快乐数


/**
 * https://leetcode-cn.com/problems/happy-number/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().isHappy(886))
            println(SolutionKt().isHappy(19))
        }
    }

    /**
     * 输入：19
     * 输出：true
     * 解释：
     * 12 + 92 = 82
     * 82 + 22 = 68
     * 62 + 82 = 100
     * 12 + 02 + 02 = 1
     */
    fun isHappy(n: Int): Boolean {
        val freq = hashMapOf<Int, Int>()
        val sum = checkHappy(   n, freq)
        if (sum == 1) {
            return true
        }
        return false
    }

    fun checkHappy(curNum: Int, freq: HashMap<Int, Int>): Int {
        if (curNum == 1) {//出现 1 递归结束
            return curNum
        }
        val saveSum = freq[curNum]
        if (saveSum != null) { //出现重复数字 递归结束
            return saveSum
        }

        var tempNum = curNum
        var sum = 0
        while (tempNum > 0) {

            var r = tempNum % 10 // 取到个位数
            sum += r * r//取平方
            tempNum /= 10
        }
        freq[curNum] = sum
        return checkHappy(sum, freq)
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
