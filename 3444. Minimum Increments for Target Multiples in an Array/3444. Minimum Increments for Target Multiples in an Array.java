/*
 * Problem: 3444. Minimum Increments for Target Multiples in an Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-increments-for-target-multiples-in-an-array/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int minimumIncrements(int[] nums, int[] target) {
        boolean[] seens = new boolean[50001];
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        Arrays.sort(target);
        int max = target[target.length - 1];
        for (int i = target.length - 1; i >= 0; i--) {
            for (int j = 1; j * target[i] <= max; j++) {
                if (seens[j * target[i]]) {
                    seens[target[i]] = true;
                    continue;
                }
            }
            if (!seens[target[i]]) {
                seens[target[i]] = true;
                list.add(target[i]);
            }
        }
        this.seens = new boolean[nums.length];
        dfs(list, nums, 0, new ArrayList<>(), 0, nums[nums.length-1]);
        return res;
    }

    int res = Integer.MAX_VALUE;
    boolean[] seens;

    public void dfs(List<Integer> list, int[] nums, int i, List<Integer> used, int n, int max) {
        if (n >= res)
            return;
        if (i == list.size()) {
            res = Math.min(n, res);
            return;
        }
        int current = list.get(i);
        for (int num : used) {
            if (num % current == 0) {
                dfs(list, nums, i + 1, used, n, max);
                return;
            }
        }
        for (int j = current; j <= 50001; j += current) {
            if (j - max + n >= res)
                return;
            int idx = binarySearch(nums, j);
            while (idx >= 0 && seens[idx]) {
                idx--;
            }
            if (idx == -1)
                continue;
            used.add(j);
            seens[idx] = true;
            dfs(list, nums, i + 1, used, n + j - nums[idx], max);
            used.removeLast();
            seens[idx] = false;
        }
    }

    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
