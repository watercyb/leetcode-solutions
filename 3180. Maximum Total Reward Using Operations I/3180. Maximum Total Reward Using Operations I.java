/*
 * Problem: 3180. Maximum Total Reward Using Operations I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-total-reward-using-operations-i/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int maxTotalReward(int[] rewardValues) {
        int max = 0;
        for (int rewardValue : rewardValues) {
            max = Math.max(rewardValue, max);
        }
        boolean[] seens = new boolean[max + 1];
        int count = 0;
        for (int rewardValue : rewardValues) {
            if (!seens[rewardValue]) {
                seens[rewardValue] = true;
                count++;
            }
        }
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 0; i < seens.length; i++) {
            if (seens[i])
                arr[idx++] = i;
        }
        return dfs(arr, new HashMap<>(), seens, arr[arr.length - 1]) + arr[arr.length - 1];
    }

    public int dfs(int[] arr, HashMap<Integer, Integer> HM, boolean[] seens, int num) {
        if (HM.containsKey(num))
            return HM.get(num);
        int idx = binarySearch(arr, num);
        if (idx == -1)
            return 0;
        if (seens[num - 1])
            return num - 1;
        int res = arr[idx];
        while (idx >= 0) {
            res = Math.max(dfs(arr, HM, seens, Math.min(arr[idx], num - arr[idx])) + arr[idx], res);
            idx--;
        }
        HM.put(num, res);
        return res;
    }

    public int binarySearch(int[] arr, int num) {
        int l = 0;
        int r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= num) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l - 1;
    }
}
