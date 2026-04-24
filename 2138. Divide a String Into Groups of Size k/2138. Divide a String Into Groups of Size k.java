/*
 * Problem: 2138. Divide a String Into Groups of Size k
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public String[] divideString(String s, int k, char fill) {
        String[] res = new String[(s.length() + k - 1) / k];
        for (int i = 0; i < res.length - 1; i++) {
            res[i] = s.substring(i * k, (i + 1) * k);
        }
        StringBuilder SB = new StringBuilder(s.substring((res.length - 1) * k, s.length()));
        while (SB.length() < k) {
            SB.append(fill);
        }
        res[res.length - 1] = SB.toString();
        return res;
    }
}
