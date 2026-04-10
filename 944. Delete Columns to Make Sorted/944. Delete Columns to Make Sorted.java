/*
 * Problem: 944. Delete Columns to Make Sorted
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/delete-columns-to-make-sorted/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char prv = 'a' - 1;
            for (String str : strs) {
                if (str.charAt(i) < prv) {
                    res++;
                    break;
                }
                prv = str.charAt(i);
            }
        }
        return res;
    }
}
