/*
 * Problem: 3333. Find the Original Typed String II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-the-original-typed-string-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int possibleStringCount(String word, int k) {
        int mod = 1_000_000_007;
        int idx = 0;
        int types = 0;
        long sum = 1;
        List<Integer> list = new ArrayList<>();
        while (idx < word.length()) {
            int count = 1;
            char chr = word.charAt(idx++);
            while (idx < word.length() && word.charAt(idx) == chr) {
                count++;
                idx++;
            }
            sum = (sum * count) % mod;
            types++;
            if (count > 1)
                list.add(count);
        }
        if (types >= k)
            return (int) (sum % mod);
        long[] DP = new long[k - types];
        DP[0] = 1;
        for (int count : list) {
            long[] DPNext = new long[DP.length];
            long prefix = 0;
            for (int i = 0; i < DP.length; i++) {
                prefix += DP[i];
                if (i - count >= 0)
                    prefix -= DP[i - count];
                DPNext[i] = prefix % mod;
            }
            DP = DPNext;
        }
        for (int i = 1; i < DP.length; i++) {
            sum -= DP[i];
        }
        return (int) ((sum % mod + mod) % mod) - 1;
    }
}
