/*
 * Problem: 1243. Array Transformation
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/array-transformation/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<Integer> transformArray(int[] arr) {
        boolean changed = true;
        while (changed) {
            changed = false;
            int[] next = arr.clone();
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    next[i]--;
                    changed = true;
                } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                    next[i]++;
                    changed = true;
                }
            }
            arr = next;
        }
        List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            res.add(num);
        }
        return res;
    }
}
