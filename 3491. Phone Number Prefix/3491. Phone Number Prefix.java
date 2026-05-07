/*
 * Problem: 3491. Phone Number Prefix
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/phone-number-prefix/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public boolean phonePrefix(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j)
                    continue;
                if (numbers[j].startsWith(numbers[i]))
                    return false;
            }
        }
        return true;
    }
}
