package com.lulu.leetcode.查找表问题._451_根据字符出现频率排序

import java.lang.StringBuilder
import java.util.*


/**
 * https://leetcode-cn.com/problems/sort-characters-by-frequency/
 *
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。 PriorityQueue 利用有序队列
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().frequencySort("tree"))
        }
    }

    /**
     * tree -> eetr
     */
    fun frequencySort(s: String): String {
        val freq = hashMapOf<Char, Int>()//字母出现频率

        for (c in s) {
            freq[c] = freq.getOrDefault(c, 0) + 1
        }

        //PriorityQueue使用跟普通队列一样，唯一区别是PriorityQueue会根据排序规则决定谁在队头，谁在队尾。
        val maxHeap =  PriorityQueue<Map.Entry<Char, Int>> { o1, o2 ->
            o2.value - o1.value
        }
        maxHeap.addAll(freq.entries)
        val stringBuilder = StringBuilder()
        while (maxHeap.isEmpty().not()) {
            val poll = maxHeap.poll()
            for (i in 0 until poll.value) {
                stringBuilder.append(poll.key)
            }
        }
        return stringBuilder.toString()
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
