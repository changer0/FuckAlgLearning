package com.lulu.leetcode.java;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {


        MaxHeap heap = new MaxHeap(500);
        heap.insert(8);
        heap.insert(5);
        heap.insert(9);
        heap.insert(1);
        heap.insert(7);

        heap.print();
        System.out.println(heap.poll());
        heap.print();
        System.out.println(heap.poll());
        heap.print();
        System.out.println(heap.poll());
        heap.print();
        System.out.println(heap.poll());

//        MaxHeap heap = new MaxHeap(500);
//        heap.insert(8);
//        heap.insert(7);
//        heap.insert(5);
//        heap.insert(1);
//        heap.print();
//        System.out.println(heap.poll());
//        heap.print();
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
