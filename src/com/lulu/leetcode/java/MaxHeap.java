package com.lulu.leetcode.java;



class MaxHeap {
    private int count = 0;
    private int[] data;

    public MaxHeap(int capacity) {
        data = new int[capacity+1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void print() {
        for(int i = 1; i <= count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void insert(int value) {
        data[++count] = value;
        shiftUp();
    }

    private void shiftUp() {
        int k = count;
        while(k > 1 && data[k] > data[k/2]) {
            swap(data, k, k/2);
            k /= 2;
        }
    }

    public int poll() {
        if(isEmpty()) {
            return -1;
        }
        int res = data[1];

        swap(data, count, 1);
        count--;
        shiftDown();
        return res;
    }

    private void shiftDown() {
        int k = 1;
        while(2*k <= count) {
            int j = 2*k;//用于交换的位置
            if(j + 1 <= count && data[j+1] > data[j]) {
                j += 1;
            }
            if(data[k] > data[j]) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}