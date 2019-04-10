package com.example.demo.tutorial;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchImpl {

   /* 1. pre-processing, sort if collection is unsorted
   *  2. binary search, using a loop or recursion to divide search space in half after each comparsion
   *  3. post-processing determine viable candidates in the remaining space
   *  https://leetcode.com/explore/learn/card/binary-search/136/template-analysis/935/
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

    // isBadVersion has been implemented, could be called.
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end-start) / 2;
            //if (!isBadVersion(mid)) start = mid + 1;
            //else end = mid;
        }
        return start;
    }

    public int mySqrt(int x) {
        if(x<=1) return x;
        int lo = 1;
        int hi = x;
        while(lo<hi)
        {
            int mid = lo +(hi-lo)/2;
            // if mid*mid<x => mid<=x/mid (e.g.mid=3,x=10)
            // if mid<=x/mid => mid*mid<=x (this is why hi will end up at the next position of the right answer)
            if(mid<=x/mid)
                lo = mid+1;
            else // if this is true, mid*mid>=x
                hi = mid;
        }
        return hi-1;
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int shift = start, len = nums.length;
        start = 0;
        end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int realmid = (mid + shift) % len;
            if (nums[realmid] == target) {
                return realmid;
            } else if (nums[realmid] < target) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end   = nums.length-1;

        while(end-start >= 2){
            int middle = start + (end - start) / 2;
            if(nums[middle]>nums[middle-1]&& nums[middle]>nums[middle+1]){
                return middle;
            }
            else if(nums[middle]>nums[middle-1]){
                start = middle+1;
            }
            else{
                end = middle-1;
            }
        }

        return nums[start]<nums[end]? end : start;
    }

    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        } else if (nums.length == 1 && nums[0] == target) {
            return new int[]{0,0};
        }
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
        }

        end = nums.length - 1;
        while (start < end) {
            int mid = start + 1 + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) {
            res[1] = end;
        }
        if (res[0] == -1) {
            res[0] = res[1];
        }
        return res;
    }

    public List<Integer> findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(A[left + i]);
        return res;
    }
}
