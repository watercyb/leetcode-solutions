/*
 * Problem: 364. Nested List Weight Sum II
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/nested-list-weight-sum-ii/
 * Language: java
 * Date: 2026-04-03
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * // Constructor initializes an empty nested list.
 * public NestedInteger();
 *
 * // Constructor initializes a single integer.
 * public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list.
 * public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer.
 * public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to
 * it.
 * public void add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1, getMax(nestedList, 2));
    }

    public int getMax(List<NestedInteger> nestedList, int n) {
        int res = n - 1;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res = Math.max(n, res);
            } else {
                res = Math.max(getMax(nestedInteger.getList(), n + 1), res);
            }
        }
        return res;
    }

    public int dfs(List<NestedInteger> nestedList, int n, int max) {
        int res = 0;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                res += (max - n) * nestedInteger.getInteger();
            } else {
                res += dfs(nestedInteger.getList(), n + 1, max);
            }
        }
        return res;
    }
}
