/*
 * Problem: 43. Multiply Strings
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/multiply-strings/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public String multiply(String num1, String num2) {
        char[] chrs1 = num1.toCharArray();
        char[] chrs2 = num2.toCharArray();
        int[] nums = new int[chrs1.length + chrs2.length];
        int idx = 0;
        for (int i = chrs1.length - 1; i >= 0; i--) {
            int a = chrs1[i] - '0';
            if (a == 0)
                continue;
            idx = chrs1.length - 1 - i;
            int carry = 0;
            for (int j = chrs2.length - 1; j >= 0; j--) {
                int num = a * (chrs2[j] - '0') + carry + nums[idx];
                nums[idx] = num % 10;
                carry = num / 10;
                idx++;
            }
            while (carry != 0) {
                int num = nums[idx] + carry;
                nums[idx] = num % 10;
                carry = num / 10;
                idx++;
            }
        }
        if (idx == 0)
            return "0";
        while (idx > 1 && nums[idx - 1] == 0) {
            idx--;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < idx; i++) {
            res.append(nums[i]);
        }
        return res.reverse().toString();
    }
}
