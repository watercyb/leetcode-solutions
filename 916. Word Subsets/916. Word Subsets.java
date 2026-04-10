/*
 * Problem: 916. Word Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/word-subsets/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] max = new int[26];
        int length = 0;
        for (String word : words2) {
            int[] counts = new int[26];
            for (char chr : word.toCharArray()) {
                int idx = chr - 'a';
                counts[idx]++;
                max[idx] = Math.max(counts[idx], max[idx]);
            }
            length = Math.max(word.length(), length);
        }
        List<String> res = new ArrayList<>();
        for (String word : words1) {
            if (word.length() < length)
                continue;
            int[] counts = new int[26];
            for (char chr : word.toCharArray()) {
                counts[chr - 'a']++;
            }
            if (chk(max, counts))
                res.add(word);
        }
        return res;
    }

    public boolean chk(int[] max, int[] counts) {
        for (int i = 0; i < max.length; i++) {
            if (counts[i] < max[i])
                return false;
        }
        return true;
    }
}
