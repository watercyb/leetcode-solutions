/*
 * Problem: 1655. Distribute Repeating Integers
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/distribute-repeating-integers/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public boolean canDistribute(int[] nums, int[] quantity) {
        int[] counts = new int[10001];
        int count = 0;
        for (int num : nums) {
            if (counts[num]++ == 0)
                count++;
        }
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0)
                arr[idx++] = counts[i];
        }
        Arrays.sort(arr);
        Arrays.sort(quantity);
        return dfs(arr, quantity, quantity.length - 1);
    }

    public boolean dfs(int[] arr, int[] quantity, int i) {
        if (i == -1)
            return true;
        for (int j = arr.length - 1; j >= 0; j--) {
            if (quantity[i] <= arr[j]) {
                if (j < arr.length - 1 && arr[j] == arr[j + 1])
                    continue;
                arr[j] -= quantity[i];
                if (dfs(arr, quantity, i - 1))
                    return true;
                arr[j] += quantity[i];
            }
        }
        return false;
    }
}
