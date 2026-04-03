/*
 * Problem: 420. Strong Password Checker
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/strong-password-checker/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int strongPasswordChecker(String password) {
        char[] chrs = password.toCharArray();
        boolean uppercase = false;
        boolean lowercase = false;
        boolean digit = false;
        int count = 1;
        int replace = 0;
        int[] counts = new int[3];
        char prv = chrs[0];
        if (Character.isUpperCase(chrs[0]))
            uppercase = true;
        else if (Character.isLowerCase(chrs[0]))
            lowercase = true;
        else if (Character.isDigit(chrs[0]))
            digit = true;
        for (int i = 1; i < chrs.length; i++) {
            if (Character.isUpperCase(chrs[i]))
                uppercase = true;
            else if (Character.isLowerCase(chrs[i]))
                lowercase = true;
            else if (Character.isDigit(chrs[i]))
                digit = true;
            if (chrs[i] == prv) {
                count++;
            } else {
                if (count >= 3) {
                    replace += count / 3;
                    counts[count % 3]++;
                }
                prv = chrs[i];
                count = 1;
            }
        }
        if (count >= 3) {
            replace += count / 3;
            counts[count % 3]++;
        }
        int needs = 0;
        if (!uppercase)
            needs++;
        if (!lowercase)
            needs++;
        if (!digit)
            needs++;
        int length = chrs.length;
        if (length < 6)
            return Math.max(6 - length, needs);
        if (length <= 20)
            return Math.max(replace, needs);
        int diff = length - 20;
        if (diff <= counts[0]) {
            return diff + Math.max(replace - diff, needs);
        }
        if (diff - counts[0] <= counts[1] * 2) {
            return diff + Math.max(replace - counts[0] - (diff - counts[0]) / 2, needs);
        }
        if (diff - counts[0] - counts[1] * 2 <= replace * 3) {
            return diff
                    + Math.max(replace - counts[0] - counts[1] - (diff - counts[0] - counts[1] * 2) / 3, needs);
        }
        return diff + needs;
    }
}
