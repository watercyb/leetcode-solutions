/*
 * Problem: 1893. Check if All the Integers in a Range Are Covered
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 * Language: java
 * Date: 2026-04-21
 */

class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] arr=new int[52];
        for (int[] range: ranges) {
            arr[range[0]]++;
            arr[range[1]+1]--;
        }

        int tmp=0;
        for (int i=0;i<=right;i++) {
            tmp+=arr[i];
            if (i>=left&&i<=right&&tmp==0) return false;
        }
        return true;
        
    }
}
