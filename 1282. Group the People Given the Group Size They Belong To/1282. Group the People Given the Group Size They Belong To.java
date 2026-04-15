/*
 * Problem: 1282. Group the People Given the Group Size They Belong To
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<Integer>[] lists = new ArrayList[501];
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (lists[groupSizes[i]] == null)
                lists[groupSizes[i]] = new ArrayList<>();
            lists[groupSizes[i]].add(i);
            if (lists[groupSizes[i]].size() == groupSizes[i]) {
                res.add(lists[groupSizes[i]]);
                lists[groupSizes[i]] = null;
            }
        }
        return res;
    }
}
