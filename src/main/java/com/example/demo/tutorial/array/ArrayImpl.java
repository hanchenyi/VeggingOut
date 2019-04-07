package com.example.demo.tutorial.array;

public class ArrayImpl {

    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i]!= A[j]) A[++j] = A[i];
        return ++j;
    }

    public void moveZeroes(int[] nums) {
        int tail = 0;
        int len = nums.length;
        for (int i = 0; i < len; i ++) {
            if (nums[i] != 0) {
                nums[tail ++] = nums[i];
            }
        }
        for (; tail < len; tail ++) {
            nums[tail] = 0;
        }
    }
}
