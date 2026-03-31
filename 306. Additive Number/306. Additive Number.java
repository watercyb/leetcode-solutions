/*
 * Problem: 306. Additive Number
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/additive-number/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() <= 2)
            return false;
        char[] chrs = num.toCharArray();
        int[] arr = new int[chrs.length];
        for (int i = 0; i < chrs.length; i++) {
            arr[i] = chrs[i] - '0';
        }
        Num a = new Num();
        int lim = arr[0] == 0 ? 1 : arr.length - 2;
        for (int i = 0; i < lim; i++) {
            a.insert(arr[i]);
            Num b = new Num();
            int lim1 = arr[i + 1] == 0 ? i + 2 : arr.length - 1;
            for (int j = i + 1; j < lim1; j++) {
                b.insert(arr[j]);
                if (dfs(arr, a, b, j + 1))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int[] arr, Num a, Num b, int i) {
        if (i == arr.length)
            return true;
        Num c = new Num();
        Num sum = a.add(b);
        int lim = arr[i] == 0 ? i + 1 : arr.length;
        while (i < lim && c.insert(arr[i]).compare(sum) < 0) {
            i++;
        }
        return c.compare(sum) == 0 && dfs(arr, b, c, i + 1);
    }
}

class Num {
    long a = 0;
    long b = 0;
    long c = 0;
    static long mod = 1_000_000_000_000_000l;

    public Num insert(int num) {
        a *= 10;
        b *= 10;
        c *= 10;
        c += num;
        b += c / mod;
        c %= mod;
        a += b / mod;
        b %= mod;
        return this;
    }

    public Num add(Num num) {
        Num res = new Num();
        res.a = a + num.a;
        res.b = b + num.b;
        res.c = c + num.c;
        res.b += res.c / mod;
        res.c %= mod;
        res.a += res.b / mod;
        res.b %= mod;
        return res;
    }

    public int compare(Num num) {
        if (a < num.a)
            return -1;
        if (a > num.a)
            return 1;
        if (b < num.b)
            return -1;
        if (b > num.b)
            return 1;
        if (c < num.c)
            return -1;
        if (c > num.c)
            return 1;
        return 0;
    }
}
