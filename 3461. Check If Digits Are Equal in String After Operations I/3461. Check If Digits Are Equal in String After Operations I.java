/*
 * Problem: 3461. Check If Digits Are Equal in String After Operations I
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public boolean hasSameDigits(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';
        }
        while (arr.length > 2) {
            arr = getArr(arr);
        }
        return arr[0] == arr[1];
    }

    public int[] getArr(int[] chrs) {
        int[] res = new int[chrs.length - 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = (chrs[i] + chrs[i + 1]) % 10;
        }
        return res;
    }
}
