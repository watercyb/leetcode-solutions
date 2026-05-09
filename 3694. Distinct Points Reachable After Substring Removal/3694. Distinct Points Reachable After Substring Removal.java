/*
 * Problem: 3694. Distinct Points Reachable After Substring Removal
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/distinct-points-reachable-after-substring-removal/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int distinctPoints(String s, int k) {
        long pos = 100000l * 100001 + 100000;
        HashSet<Long> HS = new HashSet<>();
        long[] directions = new long['V'];
        directions['U'] = 1;
        directions['D'] = -1;
        directions['L'] = -100001;
        directions['R'] = 100001;
        for (int i = 0; i < k; i++) {
            pos += directions[s.charAt(i)];
        }
        HS.add(pos);
        for (int i = k; i < s.length(); i++) {
            pos += directions[s.charAt(i)] - directions[s.charAt(i - k)];
            HS.add(pos);
        }
        return HS.size();
    }
}
