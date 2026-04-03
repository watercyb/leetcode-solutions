/*
 * Problem: 383. Ransom Note
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/ransom-note/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counts = new int['z' + 1];
        int diff = 0;
        for (char chr : ransomNote.toCharArray()) {
            if (counts[chr]++ == 0)
                diff++;
        }
        for (char chr : magazine.toCharArray()) {
            if (counts[chr]-- == 1&&diff-- == 1)
                    return true;
        }
        return false;
    }
}
