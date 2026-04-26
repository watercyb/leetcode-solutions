/*
 * Problem: 2391. Minimum Amount of Time to Collect Garbage
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        String[] types = { "G", "M", "P" };
        int res = 0;
        for (int in:travel) {
            res+=in;
        }
        res*=3;
        for (String str:garbage) {
            res+=str.length();
        }
        for (String type : types) {
            int i=garbage.length-1;
            while (i > 0 && !garbage[i].contains(type)) {
                res -= travel[i-1];
                i--;
            }
        }
        return res;
    }
}
