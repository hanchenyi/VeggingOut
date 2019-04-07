package com.example.demo.tutorial.arrayString;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayStringImpl {

    /* Array*/
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i] != A[j]) A[++j] = A[i];
        return ++j;
    }

    public void moveZeroes(int[] nums) {
        int tail = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[tail++] = nums[i];
            }
        }
        for (; tail < len; tail++) {
            nums[tail] = 0;
        }
    }

    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
        while (j > -1) A[k--] = B[j--];
    }

    public int maxSubArray(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public int missingNumber(int[] nums) {

        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }

    /* String*/
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        String minString = Arrays.asList(strs).stream().min(Comparator.comparing(String::length)).get();
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(minString) != 0) {
                minString = minString.substring(0, minString.length() - 1);
            }
        }
        return minString;
    }
}
