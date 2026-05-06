/*
 * Problem: 3347. Maximum Frequency of an Element After Performing Operations II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        List<int[]> list = new ArrayList<>();
        int prv = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prv) {
                count++;
            } else {
                list.add(new int[] { prv, count });
                prv = nums[i];
                count = 1;
            }
        }
        list.add(new int[] { prv, count });
        int len = list.size();
        int[][] arr = new int[len + 2][];
        for (int i = 0; i < len; i++) {
            arr[i + 1] = list.get(i);
        }
        arr[0] = new int[] { Integer.MIN_VALUE / 2, 0 };
        arr[arr.length - 1] = new int[] { Integer.MAX_VALUE, 0 };
        int res = 0;
        int l = 0;
        int r = 2;
        int sum = arr[1][1];
        for (int i = 1; i <= len; i++) {
            while (arr[i][0] - arr[l + 1][0] > k) {
                l++;
                sum -= arr[l][1];
            }
            while (arr[r][0] - arr[i][0] <= k) {
                sum += arr[r][1];
                r++;
            }
            int diff = sum - arr[i][1];
            res = Math.max(res, Math.min(diff, numOperations) + arr[i][1]);
            if (i != len) {
                while (true) {
                    int nextValue = arr[r][0] - k;
                    if (nextValue >= arr[i + 1][0])
                        break;
                    while (nextValue - arr[l + 1][0] > k) {
                        l++;
                        sum -= arr[l][1];
                    }
                    while (arr[r][0] - nextValue <= k) {
                        sum += arr[r][1];
                        r++;
                    }
                    res = Math.max(res, Math.min(sum, numOperations));
                }
            }
        }
        return res;
    }
}
