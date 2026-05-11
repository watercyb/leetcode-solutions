/*
 * Problem: 3883. Count Non Decreasing Arrays With Given Digit Sums
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-non-decreasing-arrays-with-given-digit-sums/
 * Language: java
 * Date: 2026-05-11
 */

class Solution {
    static int[][] arr;

    public int countArrays(int[] digitSum) {
        int mod = 1_000_000_007;
        if (arr == null) {
            List<Integer>[] lists = new ArrayList[32];
            for (int i = 0; i < 32; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i <= 5000; i++) {
                int num = i;
                int sum = 0;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                lists[sum].add(i);
            }
            arr = new int[32][];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new int[lists[i].size()];
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = lists[i].get(j);
                }
            }
        }
        long[] DP = new long[5001];
        DP[0] = 1;
        for (int num : digitSum) {
            long[] DPNext = new long[5001];
            long sum = 0;
            int i = 0;
            int j = 0;
            if (num >= 32)
                return 0;
            while (i < DP.length && j < arr[num].length) {
                while (i <= arr[num][j]) {
                    sum += DP[i];
                    i++;
                }
                DPNext[arr[num][j]] = sum % mod;
                j++;
            }
            DP = DPNext;
        }
        long res = 0;
        for (long num : DP) {
            res += num;
        }
        return (int) (res % mod);
    }
}
