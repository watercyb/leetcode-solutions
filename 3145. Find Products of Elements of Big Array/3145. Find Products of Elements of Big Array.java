/*
 * Problem: 3145. Find Products of Elements of Big Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/find-products-of-elements-of-big-array/
 * Language: java
 * Date: 2026-05-04
 */

class Solution {
    public int[] findProductsOfElements(long[][] queries) {
        long prvCount = 0;
        for (int i = 0; i < 51; i++) {
            arr[i] = (1l << (i - 1)) * i + 1;
            powerCounts[i] = prvCount + i;
            prvCount = 2 * prvCount + (arr[i] - 1) * 2;
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = pow(get(queries[i][1] + 1) - get(queries[i][0]), queries[i][2]);
        }
        return res;
    }

    long[] arr = new long[51];
    long[] powerCounts = new long[51];

    public int pow(long n, long mod) {
        long a = 2;
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1)
                res = (res * a) % mod;
            a = (a * a) % mod;
            n /= 2;
        }
        return (int) (res % mod);
    }

    public long get(long n) {
        int i = 50;
        long res = 0;
        long num = 0;
        int count = 0;
        int powerCount = 0;
        while (i >= 0) {
            long a = 1l << i;
            if (arr[i] + a * count <= n) {
                res += a * powerCount + powerCounts[i];
                num += a;
                n -= arr[i] + a * count;
                count++;
                powerCount += i;
            }
            i--;
        }
        long next = num + 1;
        long j = 0;
        while (n > 0) {
            if ((next & 1) == 1) {
                res += j;
                n--;
            }
            next >>= 1;
            j++;
        }
        return res;
    }
}
