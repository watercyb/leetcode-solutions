/*
 * Problem: 89. Gray Code
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/gray-code/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<Integer> grayCode(int n) {
        int[] arr = new int[(int) Math.pow(2, n)];
        int idx = 1;
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            for (int j = idx - 1; j >= 0; j--) {
                arr[idx++] = arr[j] + mask;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            res.add(num);
        }
        return res;
    }
}
