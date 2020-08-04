package com.lulu.leetcode.查找表问题._18_四数之和


/**
 * https://leetcode-cn.com/problems/4sum/
 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //println(SolutionKt().fourSum(intArrayOf(1, 0, -1, 0, -2, 2), 0).toString())
            println(SolutionKt().fourSum(intArrayOf(-1,0,1,2,-1,-4), -1).toString())
        }
    }

    /**
     * 参照三数之和
     */
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()//先排序
        val arr = ArrayList<ArrayList<Int>>()
        for (k in 0 until nums.size-3) {
            if (k != 0 && nums[k] == nums[k-1]) {//第一层去重
                continue
            }
            for (p in k+1 until nums.size-2) {
                if (p != k+1 && nums[p] == nums[p-1]) {//第二层去重
                    continue
                }
                var l = p+1; var r = nums.size-1
                while (l < r) {
                    val complement = nums[k] + nums[p] + nums[l] + nums[r]
                    if (complement < target) {
                        while (l < r && nums[l] == nums[++l]);
                    } else if (complement > target) {
                        while (l < r && nums[r] == nums[--r]);
                    } else {
                        arr.add(arrayListOf(nums[k], nums[p], nums[l], nums[r]))
                        while (l < r && nums[l] == nums[++l]);
                        while (l < r && nums[r] == nums[--r]);
                    }
                }
            }
        }
        return arr
    }

}
