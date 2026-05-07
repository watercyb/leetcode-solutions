/*
 * Problem: 3470. Permutations IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/permutations-iv/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] permute(int n, long k) {
        if (n % 2 == 0)
            return even(n, k);
        return odd(n, k);
    }

    public int[] even(int n, long k) {
        boolean[] used = new boolean[n + 1];
        boolean isEven = false;
        int[] res = new int[n];
        int idx = 0;
        int even = n / 2;
        int odd = even;
        boolean found = false;
        for (int i = 1; i <= n; i++) {
            long num = f(even - 1, even, k);
            if (num == -1) {
                used[i] = true;
                res[idx++] = i;
                if ((i & 1) == 1) {
                    isEven = true;
                    odd--;
                } else {
                    even--;
                }
                found = true;
                break;
            }
            k -= num;
        }
        if (!found)
            return new int[0];
        for (int i = 2; i <= n; i++) {
            if (isEven) {
                even--;
                for (int j = 2; j <= n; j += 2) {
                    if (used[j])
                        continue;
                    long num = f(even, odd, k);
                    if (num == -1) {
                        used[j] = true;
                        res[idx++] = j;
                        break;
                    }
                    k -= num;
                }
                isEven = false;
            } else {
                odd--;
                for (int j = 1; j <= n; j += 2) {
                    if (used[j])
                        continue;
                    long num = f(odd, even, k);
                    if (num == -1) {
                        used[j] = true;
                        res[idx++] = j;
                        break;
                    }
                    k -= num;
                }
                isEven = true;
            }
        }
        return res;
    }

    public int[] odd(int n, long k) {
        boolean[] used = new boolean[n + 1];
        boolean isEven = true;
        int[] res = new int[n];
        int idx = 0;
        int even = n / 2;
        int odd = even;
        boolean found = false;
        for (int i = 1; i <= n; i += 2) {
            long num = f(odd, even, k);
            if (num == -1) {
                used[i] = true;
                res[idx++] = i;
                found = true;
                break;
            }
            k -= num;
        }
        if (!found)
            return new int[0];
        for (int i = 2; i <= n; i++) {
            if (isEven) {
                even--;
                for (int j = 2; j <= n; j += 2) {
                    if (used[j])
                        continue;
                    long num = f(even, odd, k);
                    if (num == -1) {
                        used[j] = true;
                        res[idx++] = j;
                        break;
                    }
                    k -= num;
                }
                isEven = false;
            } else {
                odd--;
                for (int j = 1; j <= n; j += 2) {
                    if (used[j])
                        continue;
                    long num = f(odd, even, k);
                    if (num == -1) {
                        used[j] = true;
                        res[idx++] = j;
                        break;
                    }
                    k -= num;
                }
                isEven = true;
            }
        }
        return res;
    }

    public long f(int a, int b, long k) {
        if (k == 1)
            return -1;
        long res = 1;
        for (int i = 2; i <= a; i++) {
            res *= i;
            if (res >= k)
                return -1;
        }
        for (int i = 2; i <= b; i++) {
            res *= i;
            if (res >= k)
                return -1;
        }
        return res;
    }
}
