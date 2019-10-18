package com.example.demo.tutorial.arrayString;

import java.util.*;

public class ArrayStringImpl {

    /* Array*/
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        for (int i = 0; i < A.length; i++)
            if (A[i] != A[j]) A[++j] = A[i];
        return A.length - 1 - j;
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

    public int shortestSubarray(int[] A, int K) {
        int N = A.length; //{-1, 3, -1, 2, 4};
        long[] P = new long[N + 1];
        for (int i = 0; i < N; ++i)
            P[i + 1] = P[i] + (long) A[i];

        // Want smallest y-x with P[y] - P[x] >= K
        int ans = N + 1; // N+1 is impossible
        Deque<Integer> monoq = new LinkedList(); //opt(y) candidates, as indices of P

        for (int y = 0; y < P.length; ++y) {
            // Want opt(y) = largest x with P[x] <= P[y] - K;
            while (!monoq.isEmpty() && P[y] <= P[monoq.getLast()])
                monoq.removeLast();
            while (!monoq.isEmpty() && P[y] >= P[monoq.getFirst()] + K)
                ans = Math.min(ans, y - monoq.removeFirst());

            monoq.addLast(y);
        }

        return ans < N + 1 ? ans : -1;
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            int index = emails[i].indexOf('@');
            String local = emails[i].substring(0, index);
            String domain = emails[i].substring(index);
            int plusIndex = local.indexOf('+');
            if (plusIndex > 0) {
                local = local.substring(0, plusIndex);
            }
            local = local.replaceAll(".", "");
            set.add(local + domain);
        }
        return set.size();
    }

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num); //排序
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length - 2; i++) {
            //为了保证不加入重复的 list,因为是有序的，所以如果和前一个元素相同，只需要继续后移就可以
            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                //两个指针,并且头指针从i + 1开始，防止加入重复的元素
                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        //元素相同要后移，防止加入重复的 list
                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;
                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(formRange(lower, upper));
            return result;
        }

        // 1st step
        if (nums[0] > lower) {
            result.add(formRange(lower, nums[0] - 1));
        }

        // 2nd step
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] != nums[i] && nums[i + 1] > nums[i] + 1) {
                result.add(formRange(nums[i] + 1, nums[i + 1] - 1));
            }
        }

        // 3rd step
        if (nums[nums.length - 1] < upper) {
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    public String formRange(int low, int high) {
        return low == high ? String.valueOf(low) : (low + "->" + high);
    }

    public String noRepeatSubstring(String s) {
        int len = s.length(); // aabbcd
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i == len - 1 || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        // check if the sources string matched in S.
        // assume the order of indexes array is in ascending order
        StringBuilder sb = new StringBuilder();
        int sourceIndex = 0;
        int targetIndex = 0;
        for (int i = 0; i < sources.length; i++) {
            if (S.indexOf(sources[i]) == indexes[i]) {
                while (sourceIndex < indexes[i]) {
                    sb.append(S.charAt(sourceIndex++));
                }
                for (Character c : targets[i].toCharArray()) {
                    sb.append(c);
                }
                sourceIndex = sourceIndex + sources[i].length();
            }
        }
        while (sourceIndex < S.length()) {
            sb.append(S.charAt(sourceIndex++));
        }
        return sb.toString();
    }

    public String findReplaceString1(String S, int[] indexes, String[] sources, String[] targets) {
        int N = S.length();
        int[] match = new int[N];
        Arrays.fill(match, -1);

        for (int i = 0; i < indexes.length; ++i) {
            int ix = indexes[i];
            if (S.substring(ix, ix + sources[i].length()).equals(sources[i]))
                match[ix] = i;
        }

        StringBuilder ans = new StringBuilder();
        int ix = 0;
        while (ix < N) {
            if (match[ix] >= 0) {
                ans.append(targets[match[ix]]);
                ix += sources[match[ix]].length();
            } else {
                ans.append(S.charAt(ix++));
            }
        }
        return ans.toString();
    }

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c : S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }

    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;
        //S = "ab#c", T = "ad#c"
        while (i >= 0 || j >= 0) { // While there may be chars in build(S) or build (T)
            while (i >= 0) { // Find position of next possible char in build(S)
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else break;
            }
            while (j >= 0) { // Find position of next possible char in build(T)
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else break;
            }
            // If two actual characters are different
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j))
                return false;
            // If expecting to compare char vs nothing
            if ((i >= 0) != (j >= 0))
                return false;
            i--;
            j--;
        }
        return true;
    }

    public int minMeetingRooms(int[][] intervals) {
        // sort intervals arrays according to starting time
        // add intervals's end time into priority queue, compare current and next interval
        return 0;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, left = 0, res = 0;
        for (int right = 0; right < s.length(); right++) {
            if (count[s.charAt(right)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(left++)] > 0);
                num--;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
