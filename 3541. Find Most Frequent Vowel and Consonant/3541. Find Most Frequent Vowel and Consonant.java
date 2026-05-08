/*
 * Problem: 3541. Find Most Frequent Vowel and Consonant
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-most-frequent-vowel-and-consonant/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int maxFreqSum(String s) {
        int[] masks = new int['z' + 1];
        Arrays.fill(masks, -1);
        masks['a'] = 1;
        masks['e'] = 1;
        masks['i'] = 1;
        masks['o'] = 1;
        masks['u'] = 1;
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr] += masks[chr];
        }
        int max = 0;
        int min = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            max = Math.max(counts[i], max);
            min = Math.min(counts[i], min);
        }
        return max - min;
    }
}
