package com.lulu.leetcode._基本数据结构.二叉树;


//二分查找
class BinarySearch {

    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch(new int[]{
                0, 1, 2, 3, 4, 5, 6
        }, 7, 0, 6));
    }

    public int binarySearch(int[] data, int target, int start, int end) {
        int l = start, r = end;//两边搜索
        while (l <= r) {
            int mid = (l+r)/2;
            if (data[mid] < target) {
                l = mid+1;
            } else if (data[mid] > target) {
                r = mid-1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
