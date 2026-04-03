/*
 * Problem: 385. Mini Parser
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/mini-parser/
 * Language: java
 * Date: 2026-04-03
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        char[] chrs = s.toCharArray();
        if (chrs[0] == '[')
            idx++;
        return dfs(chrs);
    }

    int idx = 0;

    public NestedInteger dfs(char[] chrs) {
        NestedInteger res = new NestedInteger();
        int num = 0;
        int p = 1;
        while (idx < chrs.length) {
            if (chrs[idx] == '[') {
                idx++;
                res.add(dfs(chrs));
            } else if (chrs[idx] == ']') {
                if (Character.isDigit(chrs[idx - 1]))
                    res.add(new NestedInteger(p * num));
                idx++;
                return res;
            } else if (chrs[idx] == ',') {
                if (Character.isDigit(chrs[idx - 1]))
                    res.add(new NestedInteger(p * num));
                num = 0;
                p = 1;
                idx++;
            } else if (chrs[idx] == '-') {
                p = -1;
                idx++;
            } else {
                num = num * 10 + chrs[idx++] - '0';
            }
        }
        if (chrs[idx - 1] != ']')
            res.setInteger(p * num);
        return res;
    }
}
