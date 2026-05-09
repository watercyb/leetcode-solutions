/*
 * Problem: 3656. Determine if a Simple Graph Exists
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/determine-if-a-simple-graph-exists/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public boolean simpleGraphExists(int[] degrees) {
        long sum = 0;
        for (int degree : degrees) {
            sum += degree;
        }
        if (sum % 2 == 1 || sum > (long) degrees.length * (degrees.length - 1))
            return false;
        countingSort(degrees);
        sum = 0;
        int j = 0;
        long k = 0;
        for (int i = degrees.length - 1; i >= 0; i--) {
            k++;
            sum += degrees[i];
            while (j < i && degrees[j] <= k) {
                sum -= degrees[j];
                j++;
            }
            if (sum > k * (Math.max(i - j, 0) + k - 1))
                return false;
        }
        return true;
    }

    public void countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : nums) {
            counts[num]++;
        }
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[idx++] = i;
            }
        }
    }
}
