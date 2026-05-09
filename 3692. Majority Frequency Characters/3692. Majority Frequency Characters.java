/*
 * Problem: 3692. Majority Frequency Characters
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/majority-frequency-characters/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public String majorityFrequencyGroup(String s) {
        int[] counts = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)]++;
        }
        int[] freqs = new int[s.length() + 1];
        for (int i = 'a'; i <= 'z'; i++) {
            freqs[counts[i]]++;
        }
        int max = 1;
        for (int i = 2; i < freqs.length; i++) {
            if (freqs[i] >= freqs[max])
                max = i;
        }
        StringBuilder SB = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] == max)
                SB.append((char) i);
        }
        return SB.toString();
    }
}
