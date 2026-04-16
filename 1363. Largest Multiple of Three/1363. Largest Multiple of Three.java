/*
 * Problem: 1363. Largest Multiple of Three
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/largest-multiple-of-three/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int[] counts = new int[10];
        int sum = 0;
        for (int digit : digits) {
            counts[digit]++;
            sum = (sum + digit) % 3;
        }
        int count = digits.length;
        if (sum == 1) {
            if (counts[1] > 0) {
                counts[1]--;
            } else if (counts[4] > 0) {
                counts[4]--;
            } else if (counts[7] > 0) {
                counts[7]--;
            } else if (counts[2] + counts[5] + counts[8] > 1) {
                int n = 2;
                for (int i = 2; i <= 8; i += 3) {
                    while (counts[i] > 0 && n > 0) {
                        counts[i]--;
                        n--;
                    }
                }
                count--;
            } else {
                return "";
            }
            count--;
        } else if (sum == 2) {
            if (counts[2] > 0) {
                counts[2]--;
            } else if (counts[5] > 0) {
                counts[5]--;
            } else if (counts[8] > 0) {
                counts[8]--;
            } else if (counts[1] + counts[4] + counts[7] > 1) {
                int n = 2;
                for (int i = 1; i <= 7; i += 3) {
                    while (counts[i] > 0 && n > 0) {
                        counts[i]--;
                        n--;
                    }
                }
                count--;
            } else {
                return "";
            }
            count--;
        }
        if (count == 0)
            return "";
        if (counts[0] == count)
            return "0";
        char[] chrs = new char[count];
        int idx = 0;
        for (int i = 9; i >= 0; i--) {
            char chr = (char) (i + '0');
            for (int j = 0; j < counts[i]; j++) {
                chrs[idx++] = chr;
            }
        }
        return new String(chrs);
    }
}
