package com.example.demo.tutorial.recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionImpl {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generateParenthesis1(c))
                    for (String right: generateParenthesis1(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
