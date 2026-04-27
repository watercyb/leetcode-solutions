/*
 * Problem: 2429. Minimize XOR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimize-xor/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public int minimizeXor(int num1, int num2) {
        int count2 = 0;
        while (num2 > 0) {
            count2 += num2 & 1;
            num2 /= 2;
        }
        int count1 = 0;
        int num = num1;
        while (num > 0) {
            int digit = num & 1;
            count1 += digit;
            num /= 2;
        }
        int res = 0;
        if (count1 <= count2) {
            int i = 0;
            num = num1;
            while (count2 > count1) {
                int digit = (num & 1) ^ 1;
                count2 -= digit;
                res += digit << i;
                num /= 2;
                i++;
            }
        } else {
            int i = 0;
            num = num1;
            while (count1 > count2) {
                int digit = num & 1;
                count1 -= digit;
                res += digit << i;
                num /= 2;
                i++;
            }
        }
        return res ^ num1;
    }
}
