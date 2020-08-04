package com.lulu.leetcode.查找表问题._15_三数之和


/**
 * https://leetcode-cn.com/problems/3sum/
 *
 *
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组

 */
class SolutionKt {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(SolutionKt().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).toString())
            println(SolutionKt().threeSum(intArrayOf(0, 0, 0, 0, 0)).toString())
        }
    }

    /**
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
    。* [-1, -1, 2]
     * ]
     *
     * 这 TM 暴力解法都不会
     */
    fun threeSumForce(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return emptyList()
        }
        nums.sort()
        val arr = ArrayList<ArrayList<Int>>()
        var i = 0; var j = 0; var k = 0
        while (i < nums.size) {
            if (i == 0 || nums[i] != nums[i-1]) {
                j = i + 1
                while (j < nums.size) {
                    if (j == i + 1 || nums[j] != nums[j-1]) {
                        k = j + 1
                        while (k < nums.size) {
                            if (k == j + 1 || nums[k] != nums[k-1]) {
                                if (nums[i] + nums[j] + nums[k] == 0) {
                                    arr.add(arrayListOf(nums[i], nums[j], nums[k]))
                                }
                            }
                            k++
                        }
                    }
                    j++
                }

            }
            i++
        }
        return arr
    }

    /**
     * 对撞指针
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return emptyList()
        }
        nums.sort()
        val arr = ArrayList<ArrayList<Int>>()
        var k = 0
        while (k < nums.size-2) {
            if (nums[k] > 0) {
                //如果 > 0，不可能有效
                break
            }
            if (k > 0 && nums[k] == nums[k-1]) {
                k++
                continue
            }
            var i = k+1; var j = nums.size-1
            while (i < j) {
                val sum = nums[k] + nums[i] + nums[j]
                if (sum == 0) {
                    arr.add(arrayListOf(nums[k], nums[i], nums[j]))
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else {
                    while (i < j && nums[j] == nums[--j]);
                }
            }
            k++
        }

        return arr
    }

}
