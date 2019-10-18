package com.example.demo.tutorial.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapImpl {
    public int totalFruit(int[] tree) {
        // create a map to store different types fruit and num of fruits
        int ans = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < tree.length; j++) {
            if (!map.containsKey(tree[j])) {
                map.put(tree[j], 1);
            } else {
                map.put(tree[j], map.get(tree[j]) + 1);
            }

            while (map.size() > 2) {
                map.put(tree[i], map.get(tree[i]) - 1);
                if (map.get(tree[i]) == 0) {
                    map.remove(tree[i]);
                }
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}


class Counter extends HashMap<Integer, Integer> {
    public int get(int k) {
        return containsKey(k) ? super.get(k) : 0;
    }

    public void add(int k, int v) {
        put(k, get(k) + v);
    }
}