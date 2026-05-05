/*
 * Problem: 3219. Minimum Cost for Cutting Cake II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-for-cutting-cake-ii/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public long minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        countingSort(horizontalCut);
        countingSort(verticalCut);
        int i = horizontalCut.length - 1;
        int j = verticalCut.length - 1;
        int hCount = 1;
        int vCount = 1;
        long res = 0;
        while (i >= 0 && j >= 0) {
            int h = horizontalCut[i];
            int v = verticalCut[j];
            if (h > v) {
                res += h * hCount;
                vCount++;
                i--;
            } else {
                res += v * vCount;
                hCount++;
                j--;
            }
        }
        while (i >= 0) {
            res += horizontalCut[i] * hCount;
            i--;
        }
        while (j >= 0) {
            res += verticalCut[j] * vCount;
            j--;
        }
        return res;
    }

    public void countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] counts = new int[max - min + 1];
        for (int num : nums) {
            counts[num - min]++;
        }
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < counts[i]; j++) {
                nums[idx++] = i + min;
            }
        }
    }
}
