/*
 * Problem: 1104. Path In Zigzag Labelled Binary Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int n = (int) Math.floor(Math.log(label) / Math.log(2));
        int target = label;
        boolean rev = false;
        if (n % 2 == 1) {
            target = 3 * (int) Math.pow(2, n) - label - 1;
            rev = true;
        }
        List<Integer> res = new ArrayList<>();
        while (target > 1) {
            int base = (int) Math.pow(2, n);
            res.addFirst(rev ? 3 * base - target - 1 : target);
            target /= 2;
            n--;
            rev = !rev;
        }
        res.addFirst(1);
        return res;
    }
}
