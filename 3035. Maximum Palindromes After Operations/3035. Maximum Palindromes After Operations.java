/*
 * Problem: 3035. Maximum Palindromes After Operations
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-palindromes-after-operations/
 * Language: java
 * Date: 2026-05-03
 */

class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] counts = new int['z' + 1];
        int[] lenghes = new int[101];
        for (String word : words) {
            for (char chr : word.toCharArray()) {
                counts[chr]++;
            }
            lenghes[word.length()]++;
        }
        int countEven = 0;
        int countOdd = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            countEven += counts[i] / 2;
            countOdd += counts[i] % 2;
        }
        int res = 0;
        for (int i = 1; i <= 100; i++) {
            for (int j = 0; j < lenghes[i]; j++) {
                if (i % 2 == 0) {
                    countEven -= i / 2;
                    if (countEven >= 0) {
                        res++;
                    } else {
                        break;
                    }
                } else {
                    if (countOdd > 0) {
                        countOdd--;
                        countEven -= i / 2;
                        if (countEven >= 0) {
                            res++;
                        } else {
                            break;
                        }
                    } else {
                        countEven -= (i + 1) / 2;
                        if (countEven >= 0) {
                            res++;
                            countOdd++;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
