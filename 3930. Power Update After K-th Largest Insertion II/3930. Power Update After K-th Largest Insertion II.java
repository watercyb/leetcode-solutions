/*
 * Problem: 3930. Power Update After K-th Largest Insertion II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/power-update-after-k-th-largest-insertion-ii/
 * Language: java
 * Date: 2026-05-28
 */

class Solution {
    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {
        long[] arr = new long[nums.length + queries.length];
        BIT = new int[arr.length + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = ((long) nums[i] << 32);
        }
        for (int i = 0; i < queries.length; i++) {
            arr[nums.length + i] = ((long) queries[i][0] << 32) + i + 1;
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
            if (idx != 0) {
                indexes[idx - 1] = i;
            } else {
                insert(i);
            }
        }
        List<Integer> res = new ArrayList<>();
        int n = 31 - Integer.numberOfLeadingZeros(arr.length);
        for (int i = 0; i < queries.length; i++) {
            insert(indexes[i]);
            int idx = 0;
            int k = queries[i][1];
            for (int j = n; j >= 0; j--) {
                if ((idx + (1 << j)) < BIT.length && BIT[idx + (1 << j)] < k) {
                    idx += 1 << j;
                    k -= BIT[idx];
                }
            }
            int num = (int) (arr[idx] >> 32);
            p = pow(p, num);
            res.add(p);
        }
        return res;
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
