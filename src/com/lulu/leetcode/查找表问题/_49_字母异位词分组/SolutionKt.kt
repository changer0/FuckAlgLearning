package com.lulu.leetcode.查找表问题._49_字母异位词分组
/**
 * https://leetcode-cn.com/problems/group-anagrams/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
            println(SolutionKt().groupAnagrams(arrayOf("","b")))
            println(SolutionKt().groupAnagrams(arrayOf("","")))
            println(SolutionKt().groupAnagrams(arrayOf("tea","and","ace","ad","eat","dans")))
            //[["eat","tea"],["and"],["dans"],["ace"],["ad"]]
        }
    }

    /**
     * 自己实现的办法
     */
    fun groupAnagrams2(strs: Array<String>): List<List<String>> {
        val recordIndex = hashSetOf<Int>()//用来记录已经被比较过得 Index
        val res = ArrayList<ArrayList<String>>()
        for (i in 0 until strs.size) {
            if (recordIndex.contains(i)) continue
            val comStr = strs[i]
            val stringList = arrayListOf<String>()
            stringList.add(comStr)
            for (j in i+1 until strs.size) {
                if (recordIndex.contains(j)) continue
                if (isAnagrams2(comStr, strs[j])) {
                    stringList.add(strs[j])
                    recordIndex.add(j)
                }
            }
            res.add(stringList)
        }
        return res
    }

    /**
     * 排序法
     */
    fun isAnagrams2(lStr: String, rStr: String): Boolean {
        if (lStr.isEmpty() && rStr.isEmpty()) {
            return true
        }
        if (lStr.isEmpty() || rStr.isEmpty()) {
            return false
        }
        if (lStr.length != rStr.length) {
            return false
        }
        val lStrArr = lStr.toByteArray()
        val rStrArr = rStr.toByteArray()
        lStrArr.sort()
        rStrArr.sort()
        if (String(lStrArr) == String(rStrArr)) {
            return true
        }
        return false
    }

    /**
     * 字符计数法
     */
    fun isAnagrams(lStr: String, rStr: String): Boolean {
        if (lStr.isEmpty() && rStr.isEmpty()) {
            return true
        }
        if (lStr.isEmpty() || rStr.isEmpty()) {
            return false
        }
        if (lStr.length != rStr.length) {
            return false
        }
        val freqL = hashMapOf<Char, Int>()//记录字母出现频率
        val freqR = hashMapOf<Char, Int>()//记录字母出现频率
        for (c in lStr) {
            freqL[c] = freqL.getOrDefault(c, 0) + 1
        }
        for (c in rStr) {
            freqR[c] = freqR.getOrDefault(c, 0) + 1
        }
        for (mutableEntry in freqL) {
            if (freqR[mutableEntry.key] != mutableEntry.value) {
                return false
            }
        }
        return true
    }

    //------------------------------------------------------------------------------------------------------------------
    // 网上的思路 start
    /**
     * 先遍历strs，对每个string进行排序，异位词的排序结果是一样的，在map中的key值也就一样，
     * 然后在map中添加对应的ArrayList，再将ArrayList逐个添加到res中
     */
    fun groupAnagrams3(strs: Array<String>): List<List<String>> {
        val res = ArrayList<ArrayList<String>>()
        val record = hashMapOf<String, ArrayList<String>>()
        for (str in strs) {
            val bytes = str.toByteArray()
            bytes.sort()
            val key = String(bytes)
            //都会将异位词放进来
            record[key]?.add(str)?:run{record[key]= arrayListOf(str)}
        }
        for (mutableEntry in record) {
            res.add(mutableEntry.value)
        }
        return res
    }
    /**
     * 对26个字母分别赋予对应的质数值，因为不同的质数和必定为不同的数字结果，所以可以用来作为map的key值
     */
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val res = ArrayList<ArrayList<String>>()
        val record = hashMapOf<Double, ArrayList<String>>()
        val a = doubleArrayOf(2.0,3.0,5.0,7.0,11.0,13.0,17.0,19.0,23.0,29.0,
            31.0,37.0,41.0,43.0,47.0,53.0,59.0,61.0,67.0,71.0,73.0,79.0,83.0,89.0,97.0,101.0)
        for (str in strs) {
            var t = 1.0
            //不同的质数和必定为不同的数字结果
            for (c in str) {
                t *= a[c.toInt() - 'a'.toInt()]
            }
            //都会将异位词放进来
            record[t]?.add(str)?:run{record[t]= arrayListOf(str)}
        }
        for (mutableEntry in record) {
            res.add(mutableEntry.value)
        }
        return res
    }

    // 网上的思路 end
    //------------------------------------------------------------------------------------------------------------------

    /**
     * Swaps x[a] with x[b].
     */
    private fun swap(x: IntArray, a: Int, b: Int) {
        val t = x[a]
        x[a] = x[b]
        x[b] = t
    }

}
