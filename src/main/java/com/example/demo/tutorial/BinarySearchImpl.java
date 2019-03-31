package com.example.demo.tutorial;

public class BinarySearchImpl {
   /* 1. pre-processing, sort if collection is unsorted
   *  2. binary search, using a loop or recursion to divide search space in half after each comparsion
   *  3. post-processing determine viable candidates in the remaining space
   */

   public int binarySearch(int[] nums, int target) {
       if (nums == null || nums.length == 0) {
            return -1;
       }
       int left = 0, right = nums.length - 1;
       while (left <= right) {
           // prevent (left + right) overflow;
           int mid = left + (right - left) / 2;
           if (nums[mid] == target) {
               return mid;
           } else if(nums[mid] < target) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
       return -1;
   }

   /*Advanced binary search is used to search for a element or condition which requires accessing the current index
   * and its immediate right neighbor's index in the array */
   public int binarySearch2(int[] nums, int target) {
       if (nums == null || nums.length == 0) {
           return -1;
       }
       int left = 0, right = nums.length;
       while (left < right) {
           int mid = left + (right - left) / 2;
           if (nums[mid] == target) return mid;
           else if(nums[mid] < target) left = mid + 1;
           else right = mid;
       }
       if (left != nums.length && nums[left] == target) {
           return left;
       }
       return -1;
   }
}
