package com.example.demo.util.thread;

import java.util.ArrayList;
import java.util.List;

public class SortImpl {
    public void quickSort(int[] nums, int low, int high) {
        if (nums.length == 0) {
            return;
        }
        if (low > high) {
            return;
        }
        int start = low, end = high;
        int pivot = (low + high) / 2;
        while(low <= high) {
            while (nums[pivot] > nums[low]) {
                low ++;
            }
            while (nums[pivot] < nums[high]) {
                high --;
            }
            if (low <= high) {
                int t = nums[low];
                nums[low] = nums[high];
                nums[high] = t;
                low ++;
                high --;
            }
        }
        quickSort(nums, start, high);
        quickSort(nums, low, end);
    }

    public int[] mergeSort(int[] array) {
        int len = array.length;
        if (array.length < 2) {
            return array;
        }
        int middle = len / 2;
        int[] left = new int[middle];
        int[] right = new int[len - middle];
        for (int i = 0; i < middle; i ++) {
            left[i] = array[i];
            right[i] = array[middle + 1];
        }
        if (len % 2 != 0) {
            right[len - middle - 1] = array[len - 1];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;
        int[] mergedArray = new int[leftLen + rightLen];
        int i = 0, j = 0, k = 0;
        while (i < leftLen && j < rightLen) {
            mergedArray[k ++] = left[i] < right[j] ? left[i ++] : right[j ++];
        }
        while (i < leftLen) {
            mergedArray[k ++] = left[i ++];
        }
        while (i < rightLen) {
            mergedArray[k ++] = right[j ++];
        }
        return mergedArray;
    }
}
