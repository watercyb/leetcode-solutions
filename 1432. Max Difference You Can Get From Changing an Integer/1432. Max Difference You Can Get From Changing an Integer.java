/*
 * Problem: 1432. Max Difference You Can Get From Changing an Integer
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int maxDiff(int num) {
        char[] chrs = String.valueOf(num).toCharArray();
        int max = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] != '9') {
                char t = chrs[i];
                while (i < chrs.length) {
                    if (chrs[i] == t) {
                        max = max * 10 + 9;
                    } else {
                        max = max * 10 + chrs[i] - '0';
                    }
                    i++;
                }
            } else {
                max = max * 10 + chrs[i] - '0';
            }
        }
        int min = 0;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] > '1') {
                char t = chrs[i];
                int idx = i;
                while (i < chrs.length) {
                    if (chrs[i] == t) {
                        if (idx == 0) {
                            min = min * 10 + 1;
                        } else {
                            min = min * 10;
                        }
                    } else {
                        min = min * 10 + chrs[i] - '0';
                    }
                    i++;
                }
            } else {
                min = min * 10 + chrs[i] - '0';
            }
        }
        return max - min;
    }
}
