/*
 * Problem: 217. Contains Duplicate
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/contains-duplicate/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> HS= new HashSet<Integer>();
        for (int num: nums) {
            if (!HS.add(num)) {return true;}
        }
        return false;
    }
}
