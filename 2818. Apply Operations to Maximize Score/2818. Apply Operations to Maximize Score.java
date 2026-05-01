/*
 * Problem: 2818. Apply Operations to Maximize Score
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/apply-operations-to-maximize-score/
 * Language: java
 * Date: 2026-05-01
 */

class Solution {
    int mod = 1_000_000_007;

    public int maximumScore(List<Integer> nums, int k) {
        int[] arr = new int[nums.size()];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums.get(i);
            max = Math.max(arr[i], max);
        }
        int[] primeScores = getScores(arr, max);
        int[] lefts = new int[arr.length];
        int[] MQ = new int[arr.length + 1];
        int[] pos = new int[arr.length + 1];
        MQ[0] = Integer.MAX_VALUE;
        pos[0] = -1;
        int idx = 1;
        for (int i = 0; i < arr.length; i++) {
            while (MQ[idx - 1] < primeScores[arr[i]]) {
                idx--;
            }
            lefts[i] = i - pos[idx - 1];
            pos[idx] = i;
            MQ[idx++] = primeScores[arr[i]];
        }
        long[] counts = new long[max + 1];
        MQ[0] = Integer.MAX_VALUE;
        pos[0] = arr.length;
        idx = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            while (MQ[idx - 1] <= primeScores[arr[i]]) {
                idx--;
            }
            counts[arr[i]] += (long) lefts[i] * (pos[idx - 1] - i);
            pos[idx] = i;
            MQ[idx++] = primeScores[arr[i]];
        }
        long res = 1;
        for (int i = max; i >= 0; i--) {
            if (counts[i] == 0)
                continue;
            if (counts[i] >= k) {
                res = res * pow(i, k) % mod;
                break;
            } else {
                k -= counts[i];
                res = res * pow(i, counts[i]) % mod;
            }
        }
        return (int) res;
    }

    public int[] getScores(int[] arr, int max) {
        int[] res = new int[max + 1];
        int[] minPrimes = getMinPrimes(max);
        for (int i = 0; i < arr.length; i++) {
            if (res[arr[i]] != 0)
                continue;
            int num = arr[i];
            while (num > 1) {

                res[arr[i]]++;
                int div = minPrimes[num];
                while (minPrimes[num] == div) {
                    num /= div;
                }
            }
        }
        return res;
    }

    public int[] getMinPrimes(int max) {
        int[] res = new int[max + 1];
        for (int i = 2; i <= max; i += 2) {
            res[i] = 2;
        }
        int lim = (int) Math.sqrt(max);
        for (int i = 3; i <= max; i += 2) {
            if (res[i] != 0)
                continue;
            res[i] = i;
            if (i <= lim) {
                for (int j = i * i; j <= max && j > 0; j += 2 * i) {
                    if (res[j] == 0)
                        res[j] = i;
                }
            }
        }
        return res;
    }

    public long pow(int a, long b) {
        long res = 1;
        long base = a;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * base % mod;
            base = base * base % mod;
            b /= 2;
        }
        return res;
    }
}
