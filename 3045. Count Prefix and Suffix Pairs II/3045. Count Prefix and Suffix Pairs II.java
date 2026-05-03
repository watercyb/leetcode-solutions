/*
 * Problem: 3045. Count Prefix and Suffix Pairs II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public long countPrefixSuffixPairs(String[] words) {
        boolean[] seens = new boolean[words.length];
        long res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            if (seens[i])
                continue;
            int count = 1;
            int l = words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                if (l > words[j].length())
                    continue;
                if (words[i].equals(words[j])) {
                    seens[j] = true;
                    res += count;
                    count++;
                } else if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
                    res += count;
                }
            }
        }
        return res;
    }
}
