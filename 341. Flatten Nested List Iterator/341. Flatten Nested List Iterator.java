/*
 * Problem: 341. Flatten Nested List Iterator
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/flatten-nested-list-iterator/
 * Language: java
 * Date: 2026-04-03
 */

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
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
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list
 * // Return empty list if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> Li = new ArrayList<>();
    int n = 0;

    public NestedIterator(List<NestedInteger> nestedList) {
        Li = new ArrayList<>();
        n = 0;
        dfs(nestedList);
    }

    public void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger NI : nestedList) {
            if (NI.isInteger()) {
                Li.add(NI.getInteger());
            } else {
                dfs(NI.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if (n==Li.size()) return null;
        return Li.get(n++);
    }

    @Override
    public boolean hasNext() {
        return n != Li.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
