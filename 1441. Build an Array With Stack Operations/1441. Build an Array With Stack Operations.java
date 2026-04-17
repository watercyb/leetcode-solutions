/*
 * Problem: 1441. Build an Array With Stack Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/build-an-array-with-stack-operations/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < target.length; i++) {
            while (target[i] != j) {
                res.add("Push");
                res.add("Pop");
                j++;
            }
            res.add("Push");
            j++;
        }
        return res;
    }
}
