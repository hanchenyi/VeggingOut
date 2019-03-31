package com.example.demo.util.thread;

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
}
