/*
 * Problem: 763. Partition Labels
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/partition-labels/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] chrs = s.toCharArray();
        int[] pos = new int['z' + 1];
        for (int i = 0; i < chrs.length; i++) {
            pos[chrs[i]] = i;
        }
        int idx = 0;
        int prv = 0;
        List<Integer> res = new ArrayList<>();
        while (idx < chrs.length) {
            int last = pos[chrs[idx]];
            while (idx <= last) {
                last = Math.max(pos[chrs[idx]], last);
                idx++;
            }
            res.add(idx - prv);
            prv = idx;
        }
        return res;
    }
}
