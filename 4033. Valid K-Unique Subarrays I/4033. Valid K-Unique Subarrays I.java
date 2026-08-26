/*
 * Problem: 4033. Valid K-Unique Subarrays I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/valid-k-unique-subarrays-i/
 * Language: java
 * Date: 2026-08-26
 */

class Solution {
    public boolean[] validSubarrays(int[] nums, int k, int[][] queries) {
        return mo(nums, k, queries);
    }

    public boolean[] mo(int[] nums, int k, int[][] queries) {
        int len = 500;
        int n = nums.length / len;
        List<int[]>[] lists = new ArrayList[n + 1];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int idx = l / len;
            lists[idx].add(new int[] { l, r, i });
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] res = new boolean[queries.length];
        boolean ascending = true;
        int l = 0;
        int r = 0;
        int dist = 1;
        int odd = 1;
        int[] counts = new int[max + 1];
        counts[nums[0]] = 1;
        for (List<int[]> list : lists) {
            if (list.isEmpty())
                continue;
            if (ascending) {
                list.sort((a, b) -> a[1] - b[1]);
            } else {
                list.sort((a, b) -> b[1] - a[1]);
            }
            ascending = !ascending;
            for (int[] arr : list) {
                int lNext = arr[0];
                int rNext = arr[1];
                int idx = arr[2];
                while (l > lNext) {
                    l--;
                    int count = ++counts[nums[l]];
                    if (count == 1)
                        dist++;
                    odd += (count & 1) * 2 - 1;
                }
                while (l < lNext) {
                    int count = --counts[nums[l]];
                    if (count == 0)
                        dist--;
                    odd += (count & 1) * 2 - 1;
                    l++;
                }
                while (r < rNext) {
                    r++;
                    int count = ++counts[nums[r]];
                    if (count == 1)
                        dist++;
                    odd += (count & 1) * 2 - 1;
                }
                while (r > rNext) {
                    int count = --counts[nums[r]];
                    if (count == 0)
                        dist--;
                    odd += (count & 1) * 2 - 1;
                    r--;
                }
                res[idx] = dist == k && odd == 0;
            }
        }
        return res;
    }

    public boolean[] getRes(int[] nums, int k, int[][] queries) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[][] isGoods = new boolean[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            int dist = 0;
            int odd = 0;
            int[] counts = new int[max + 1];
            for (int j = i; j < nums.length; j++) {
                int count = ++counts[nums[j]];
                if (count == 1) {
                    dist++;
                    if (dist > k)
                        break;
                }
                odd += (count & 1) * 2 - 1;
                if (dist == k && odd == 0)
                    isGoods[i][j] = true;
            }
        }
        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = isGoods[queries[i][0]][queries[i][1]];
        }
        return res;
    }
}
