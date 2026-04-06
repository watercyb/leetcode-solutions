/*
 * Problem: 670. Maximum Swap
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-swap/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int maximumSwap(int num) {
        char[] chrs = String.valueOf(num).toCharArray();
        int[] idx = new int['9' + 1];
        Arrays.fill(idx, -1);
        for (int i = 0; i < chrs.length; i++) {
            idx[chrs[i]] = i;
        }
        int j = '9';
        for (int i = 0; i < chrs.length - 1 && j >= '0'; i++) {
            while (j > chrs[i]) {
                if (idx[j] > i) {
                    char tmp = chrs[i];
                    chrs[i] = chrs[idx[j]];
                    chrs[idx[j]] = tmp;
                    return Integer.valueOf(new String(chrs));
                }
                j--;
            }
        }
        return num;
    }
}
