package com.example.demo.tutorial.sort;

import com.example.demo.tutorial.model.ListNode;
import com.example.demo.tutorial.model.Worker;

import java.util.*;

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
        int[] order = new int[10]; //数组order[i]用来表示该位是i的数的个数
        while (m <= d) {
            for (int i = 0; i < number.length; i++) {
                int lsd = ((number[i] / n) % 10);
                temp[lsd][order[lsd]] = number[i]; //
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

    public ListNode mergeKLists(List<ListNode> lists) {
        int length = lists.size();

        if (length == 0)
            return null;
        if (length == 1) {
            return lists.get(0);
        }

        int mid = (length - 1) / 2;
        ListNode l1 = mergeKLists(lists.subList(0, mid + 1));
        ListNode l2 = mergeKLists(lists.subList(mid + 1, length));

        return mergeTowLists(l1, l2);

    }

    public ListNode mergeTowLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode list = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }

        while (l1 != null) {
            list.next = l1;
            l1 = l1.next;
            list = list.next;
        }

        while (l2 != null) {
            list.next = l2;
            l2 = l2.next;
            list = list.next;
        }

        return result.next;
    }

    class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            if (o1.val < o2.val)
                return -1;
            else if (o1.val == o2.val)
                return 0;
            else
                return 1;
        }

    }

    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for (int i = 0; i < lists.length; i++) {
            ListNode node = lists[i];
            if (node != null) {
                queue.add(node);
            }
        }


        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;

            if (tail.next != null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    // For each worker in order of ratio, we know all currently considered workers have lower ratio.         //(This worker will be the 'captain', as described in Approach #1.)
    //We calculate the candidate answer as this ratio times the sum of the smallest K workers in quality.
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int N = quality.length;
        Worker[] workers = new Worker[N];
        for (int i = 0; i < N; ++i)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers);

        double ans = 1e9;
        int sumq = 0;
        PriorityQueue<Integer> pool = new PriorityQueue();
        for (Worker worker: workers) {
            pool.offer(-worker.quality);
            sumq += worker.quality;
            if (pool.size() > K)
                sumq += pool.poll();
            if (pool.size() == K)
                ans = Math.min(ans, sumq * worker.ratio());
        }

        return ans;
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi, pivot = arr[lo];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = pivot;
        return i;
    }

    public static int quickSelect(int[] arr, int k) {
        k = arr.length - k;
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int i = partition(arr, lo, hi);
            if (i < k) {
                lo = i + 1;
            }
            else if (i > k) {
                hi = i - 1;
            }
            else {
                return arr[i];
            }
        }
        return arr[lo];
    }
}
