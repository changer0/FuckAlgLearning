package com.lulu.leetcode.java;

public class Solution {
    public static void main(String[] args) {

    }
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
