/*
 * Problem: Unknown Problem
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/power-update-after-k-th-largest-insertion-ii/
 * Language: java
 * Date: 2026-05-13
 */

class Solution {
    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        long[] arr = new long[nums.length + queries.length];
        BIT = new int[arr.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = ((long) nums[i] << 32) + 100000;
        }
        for (int i = 0; i < queries.length; i++) {
            arr[nums.length + i] = ((long) queries[i][0] << 32) + i;
        }
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            long temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        int[] indexes = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            int idx = (int) arr[i];
            if (idx != 100000) {
                indexes[idx] = i;
            }
        }
        int[] res = new int[queries.length];
        for (int i = queries.length - 1; i >= 0; i--) {
            l = queries[i][1] - 1;
            r = arr.length - 1;
            while (l < r) {
                int mid = (l + r) >>> 1;
                int idx = mid - get(mid);
                if (idx >= queries[i][1] - 1) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int num = (int) (arr[l] >> 32);
            res[i] = num;
            insert(indexes[i]);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            p = pow(p, res[i]);
            resList.add(p);
        }
        return resList;
    }

    public int pow(long a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % mod;
            a = a * a % mod;
            b >>= 1;
        }
        return (int) res;
    }

    int[] BIT;
    int mod = 1_000_000_007;

    public void insert(int i) {
        i++;
        while (i < BIT.length) {
            BIT[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += BIT[i];
            i -= i & -i;
        }
        return res;
    }
}
