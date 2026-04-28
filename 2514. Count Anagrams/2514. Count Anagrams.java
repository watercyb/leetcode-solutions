/*
 * Problem: 2514. Count Anagrams
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-anagrams/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    int mod = 1_000_000_007;

    public int countAnagrams(String s) {
        long res = 1;
        long div = 1;
        int count = 0;
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            if (chr == ' ') {
                count = 0;
                counts = new int['z' + 1];
            } else {
                count++;
                res = (res * count) % mod;
                div = (div * ++counts[chr]) % mod;
            }
        }
        return (int) (res * modInv(div) % mod);
    }

    public long modInv(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * modInv(mod % a) % mod;
    }
}
