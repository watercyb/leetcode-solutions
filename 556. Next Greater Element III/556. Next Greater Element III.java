/*
 * Problem: 556. Next Greater Element III
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/next-greater-element-iii/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public int nextGreaterElement(int n) {
        long num = n;
        int[] counts = new int[10];
        int max = (int) num % 10;
        counts[max]++;
        num /= 10;
        while (num > 0) {
            int digit = (int) num % 10;
            counts[digit]++;
            if (digit < max) {
                int idx = digit+1;
                while (counts[idx] == 0) {
                    idx++;
                }
                num -= digit - idx;
                counts[idx]--;
                for (int i = 0; i < counts.length; i++) {
                    for (int j = 0; j < counts[i]; j++) {
                        num *= 10;
                        num += i;
                    }
                }
                if (num > Integer.MAX_VALUE)
                    return -1;
                return (int) num;
            }
            max = digit;
            num /= 10;
        }
        return -1;
    }
}
