/*
 * Problem: 273. Integer to English Words
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/integer-to-english-words/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        StringBuilder res = new StringBuilder();
        int tmp = num / 1_000_000_000;
        if (tmp > 0) {
            res.append(nums1[tmp]);
            res.append(" Billion");
        }
        num %= 1_000_000_000;
        tmp = num / 1_000_000;
        if (num / 1_000_000 > 0) {
            res.append(thousand(tmp));
            res.append(" Million");
        }
        num %= 1_000_000;
        tmp = num / 1_000;
        if (num / 1_000 > 0) {
            res.append(thousand(tmp));
            res.append(" Thousand");
        }
        num %= 1_000;
        if (num > 0) {
            res.append(thousand(num));
        }
        res.deleteCharAt(0);
        return res.toString();
    }

    static String[] nums1 = { "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine",
            " Ten",
            " Eleven",
            " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen" };
    static String[] nums2 = { "", "", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty",
            " Ninety" };

    public String thousand(int num) {
        StringBuilder SB = new StringBuilder();
        int tmp = num / 100;
        if (tmp > 0) {
            SB.append(nums1[tmp]);
            SB.append(" Hundred");
        }
        num %= 100;
        if (num >= 20) {
            SB.append(nums2[num / 10]);
            if (num % 10 > 0) {
                SB.append(nums1[num % 10]);
            }
        } else if (num > 0) {
            SB.append(nums1[num]);
        }
        return SB.toString();
    }
}
