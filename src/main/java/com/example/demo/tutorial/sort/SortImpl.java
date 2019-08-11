package com.example.demo.tutorial.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortImpl {

    // Time O(nlogn) worst O(n^2)
    public void quickSort(int[] nums, int low, int high) {
        if (nums.length == 0) {
            return;
        }
        if (low > high) {
            return;
        }
        int start = low, end = high;
        int pivot = (low + high) / 2;
        while (low <= high) {
            while (nums[pivot] > nums[low]) {
                low++;
            }
            while (nums[pivot] < nums[high]) {
                high--;
            }
            if (low <= high) {
                int t = nums[low];
                nums[low] = nums[high];
                nums[high] = t;
                low++;
                high--;
            }
        }
        quickSort(nums, start, high);
        quickSort(nums, low, end);
    }

    // Time O(nlogn) Space depends
    public int[] mergeSort(int[] array) {
        int len = array.length;
        if (array.length < 2) {
            return array;
        }
        int middle = len / 2;
        int[] left = new int[middle];
        int[] right = new int[len - middle];
        for (int i = 0; i < middle; i++) {
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
            mergedArray[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while (i < leftLen) {
            mergedArray[k++] = left[i++];
        }
        while (i < rightLen) {
            mergedArray[k++] = right[j++];
        }
        return mergedArray;
    }

    // Time O(n^2) Space O(1)
    public int[] bubbleSort(int[] array) {
        for (int i = array.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int t = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = t;
                }
            }
        }
        return array;
    }

    // Time O(n^2) Space O(1)
    public int[] insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j >= 0; j--) {
                if (array[j + 1] < array[j]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        return array;
    }

    //时间效率：设待排序列为n个记录，d个关键码，关键码的取值范围为radix，则进行链式基数排序的时间复杂度为O(d(n+radix))，其中，一趟分配时间复杂度为O(n)，一趟收集时间复杂度为O(radix)，共进行d趟分配和收集。
    //空间效率：需要2*radix个指向队列的辅助空间，以及用于静态链表的n个指针。
    public void radixSort(int[] number) //d表示最大的数有多少位
    {
        int max = Arrays.stream(number).max().getAsInt();
        int d = 0;
        while (max > 0) {
            d++;
            max /= 10;
        }

        int k = 0;
        int n = 1;
        int m = 1; //控制键值排序依据在哪一位
        int[][] temp = new int[10][number.length]; //数组的第一维表示可能的余数0-9
        int[] order = new int[10]; //数组orderp[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0)
                    for (int j = 0; j < order[i]; j++) {
                        number[k] = temp[i][j];
                        k++;
                    }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}
