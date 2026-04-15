/*
 * Problem: 1207. Unique Number of Occurrences
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/unique-number-of-occurrences/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[arr.length + 1];
        HashMap<Integer,Integer> HM=new HashMap<>();
        for (int in:arr) {
            HM.put(in,HM.getOrDefault(in,0)+1);
        }
        for (int count:HM.values()) {
            if (counts[count]!=0) {
                return false;
            } else {
                counts[count]++;
            }
        }
        return true;
    }
}
