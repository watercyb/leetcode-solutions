/*
 * Problem: 1375. Number of Times Binary String Is Prefix-Aligned
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int numTimesAllBlue(int[] flips) {
        int[] BT = new int[flips.length + 1];
        int res = 0;
        int last=-1;
        for (int flip : flips) {
            updateSum(BT, flip, 1);
            if (flip>last) last=flip;
            if (getSum(BT,flips.length)==last) res++;
        }
        return res;
    }

    public void updateSum(int[] BT, int i, int num) {
        while (i < BT.length) {
            BT[i]+=num;
            i += i&-i;
        }
    }

    public int getSum(int[] BT, int i) {
        int sum=0;
        while (i > 0) {
            sum+=BT[i];
            i -= i&-i;
        }
        return sum;
    }
}

