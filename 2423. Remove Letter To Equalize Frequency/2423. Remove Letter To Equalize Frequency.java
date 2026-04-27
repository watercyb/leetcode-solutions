/*
 * Problem: 2423. Remove Letter To Equalize Frequency
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-letter-to-equalize-frequency/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public boolean equalFrequency(String word) {
        int[] counts = new int['z' + 1];
        for (char chr : word.toCharArray()) {
            counts[chr]++;
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        int totalCount = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] == 0)
                continue;
            totalCount++;
            if (counts[i] < min) {
                min = counts[i];
                count = 1;
            } else if (counts[i] == min) {
                count++;
            }
        }
        if (totalCount == 1)
            return true;
        boolean isChanged = false;
        boolean isFalse = false;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] <= min)
                continue;
            if (counts[i] > min + 1 || isChanged)
                isFalse = true;
            isChanged = true;
        }
        if (!isFalse && (isChanged || min == 1))
            return true;
        if (min == 1 && count == 1) {
            int target = 0;
            for (int i = 'a'; i <= 'z'; i++) {
                if (counts[i] <= 1)
                    continue;
                if (target == 0) {
                    target = counts[i];
                } else if (target != counts[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
