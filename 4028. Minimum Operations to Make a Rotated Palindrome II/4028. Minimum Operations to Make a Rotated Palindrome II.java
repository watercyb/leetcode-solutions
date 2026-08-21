/*
 * Problem: 4028. Minimum Operations to Make a Rotated Palindrome II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-a-rotated-palindrome-ii/
 * Language: java
 * Date: 2026-08-21
 */

class Solution {
    public int minOperations(String s) {
        int[] hs = new int[26];
        for (int i = 0; i < 26; i++) {
            int l = Math.max(i - 12, 0);
            int r = Math.min(i, 12);
            while (l <= r) {
                hs[i] += 1 << l;
                l++;
            }
        }
        char[] chrs = s.toCharArray();
        int[] indexes = new int[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            indexes[i] = chrs[i] - 'a';
        }
        int[] steps = new int[indexes.length];
        int idx = (indexes.length - 1) / 2;
        for (int i = 0; i < indexes.length; i++) {
            steps[idx] = i;
            idx++;
            if (idx == indexes.length)
                idx = 0;
        }
        for (int i = 0; i < 13; i++) {
            int mask = 1 << i;
            int[] arr = new int[indexes.length];
            int count = 0;
            for (int j = 0; j < indexes.length; j++) {
                int n = (hs[indexes[j]] & mask) == 0 ? 0 : 1;
                arr[j] = n;
                count += n;
            }
            int[] pros = getPros(arr);
            for (int j = 0; j < pros.length; j++) {
                steps[j] += count - pros[j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int step : steps) {
            res = Math.min(res, step);
        }
        return res;
    }

    NTT ntt = new NTT();
    long MOD = 998244353;

    public int[] getPros(int[] arr) {
        long[] c = convolution(arr);
        int[] res = new int[arr.length];
        int n = arr.length;
        if (arr.length % 2 == 1) {
            for (int x = 0; x < n; x++) {
                int k = (2 * x) % n;
                long circular = c[k] + (k + n < c.length ? c[k + n] : 0);
                res[x] = (int) (circular);
            }
        } else {
            for (int x = 0; x < n; x++) {
                int k = (2 * x + 1) % n;

                long circular = c[k] +
                        (k + n < c.length ? c[k + n] : 0);

                res[x] = (int) circular;
            }
        }
        return res;
    }

    public long[] convolution(int[] arr) {
        int resultSize = arr.length * 2 - 1;

        int n = 1;
        while (n < resultSize) {
            n <<= 1;
        }

        long[] fa = new long[n];
        for (int i = 0; i < arr.length; i++) {
            fa[i] = arr[i];
        }

        ntt.ntt(fa, false);

        // Pointwise multiplication
        for (int i = 0; i < n; i++) {
            fa[i] = fa[i] * fa[i] % MOD;
        }

        // Inverse NTT
        ntt.ntt(fa, true);

        return Arrays.copyOf(fa, resultSize);
    }

    class NTT {
        final long MOD = 998244353;
        final long ROOT = 3;

        public long modPow(long a, long e) {
            long result = 1;

            while (e > 0) {
                if ((e & 1) != 0) {
                    result = result * a % MOD;
                }

                a = a * a % MOD;
                e >>= 1;
            }

            return result;
        }

        public void ntt(long[] a, boolean invert) {
            int n = a.length;

            // Bit-reversal permutation
            for (int i = 1, j = 0; i < n; i++) {
                int bit = n >> 1;

                while ((j & bit) != 0) {
                    j ^= bit;
                    bit >>= 1;
                }

                j ^= bit;

                if (i < j) {
                    long temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }

            // Butterfly stages
            for (int len = 2; len <= n; len <<= 1) {
                long wLen = modPow(ROOT, (MOD - 1) / len);

                if (invert) {
                    wLen = modPow(wLen, MOD - 2);
                }

                for (int i = 0; i < n; i += len) {
                    long w = 1;

                    for (int j = 0; j < len / 2; j++) {
                        long u = a[i + j];
                        long v = a[i + j + len / 2] * w % MOD;

                        a[i + j] = (u + v) % MOD;
                        a[i + j + len / 2] = (u - v + MOD) % MOD;

                        w = w * wLen % MOD;
                    }
                }
            }

            // Divide by n for inverse NTT
            if (invert) {
                long nInv = modPow(n, MOD - 2);

                for (int i = 0; i < n; i++) {
                    a[i] = a[i] * nInv % MOD;
                }
            }
        }
    }
}
