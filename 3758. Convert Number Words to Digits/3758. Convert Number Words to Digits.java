/*
 * Problem: 3758. Convert Number Words to Digits
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/convert-number-words-to-digits/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public String convertNumber(String s) {
        String[] strs = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        char[][] arr = new char[10][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = strs[i].toCharArray();
        }
        char[] chrs = s.toCharArray();
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < chrs.length; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (chk(chrs, arr[j], i)) {
                    SB.append(j);
                    i += arr[j].length - 1;
                    break;
                }
            }
        }
        return SB.toString();
    }

    public boolean chk(char[] chrs, char[] target, int i) {
        if (chrs.length - i < target.length)
            return false;
        for (int j = 0; j < target.length; j++) {
            if (chrs[i + j] != target[j])
                return false;
        }
        return true;
    }
}
