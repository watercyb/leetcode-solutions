/*
 * Problem: 3695. Maximize Alternating Sum Using Swaps
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-alternating-sum-using-swaps/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public long maxAlternatingSum(int[] nums, int[][] swaps) {
        int[] links = new int[nums.length];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        for (int[] swap : swaps) {
            int a = find(links, swap[0]);
            int b = find(links, swap[1]);
            links[a] = b;
        }
        int count = 0;
        int[] counts = new int[nums.length];
        for (int i = 0; i < links.length; i++) {
            if (links[i] == i)
                count++;
            counts[find(links, i)]++;
        }
        int[] groupToIdx = new int[nums.length];
        int groupIdx = 0;
        int[][] arr = new int[count][];
        int[] arrCount = new int[count];
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                groupToIdx[i] = groupIdx;
                arr[groupIdx] = new int[counts[i]];
                groupIdx++;
            }
        }
        int[] arrIdx = new int[count];
        for (int i = 0; i < nums.length; i++) {
            int a = find(links, i);
            int grp = groupToIdx[a];
            arr[grp][arrIdx[grp]] = nums[i];
            arrCount[grp] += i % 2;
            arrIdx[grp]++;
        }
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += getSum(arr[i], arrCount[i]);
        }
        return res;
    }

    public long getSum(int[] arr, int count) {
        Arrays.sort(arr);
        long res = 0;
        for (int i = 0; i < count; i++) {
            res -= arr[i];
        }
        for (int i = count; i < arr.length; i++) {
            res += arr[i];
        }
        return res;
    }

    public int find(int[] links, int i) {
        if (links[i] != i)
            links[i] = find(links, links[i]);
        return links[i];
    }
}
