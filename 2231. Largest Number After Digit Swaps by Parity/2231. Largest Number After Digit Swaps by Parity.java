/*
 * Problem: 2231. Largest Number After Digit Swaps by Parity
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int largestInteger(int num) {
        int[] countOdd = new int[101];
        int[] countEven = new int[101];
        int numTmp = num;
        char[] res = new char[String.valueOf(num).length()];
        int idx = res.length - 1;
        while (numTmp > 0) {
            int digit = numTmp % 10;
            if (digit % 2 == 0) {
                countEven[digit]++;
            } else {
                countOdd[digit]++;
                res[idx] = 1;
            }
            numTmp /= 10;
            idx--;
        }
        int idxOdd = 0;
        int idxEven = 0;
        numTmp = num;
        idx = res.length - 1;
        while (idx >= 0) {
            if (res[idx] == 0) {
                while (countEven[idxEven] == 0) {
                    idxEven++;
                }
                res[idx] = (char) (idxEven + '0');
                countEven[idxEven]--;
            } else {
                while (countOdd[idxOdd] == 0) {
                    idxOdd++;
                }
                res[idx] = (char) (idxOdd + '0');
                countOdd[idxOdd]--;
            }
            idx--;
        }
        return Integer.parseInt(new String(res));
    }
}
