/*
 * Problem: 3518. Smallest Palindromic Rearrangement II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-palindromic-rearrangement-ii/?envType=daily-question&envId=2026-07-29
 * Language: java
 * Date: 2026-07-29
 */

class Solution {
    public String smallestPalindrome(String s, int k) {
        if (s.length() == 1) {
            if (k == 1)
                return s;
            return "";
        }
        int[] counts = new int['z' + 1];
        for (char chr : s.toCharArray()) {
            counts[chr]++;
        }
        char mid = '#';
        char[] chrs = new char[s.length() / 2];
        int idx = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            if (counts[i] % 2 == 1)
                mid = (char) i;
            counts[i] /= 2;
            for (int j = 0; j < counts[i]; j++) {
                chrs[idx++] = (char) i;
            }
            counts[i] = 0;
        }
        String str = dfsToLeft(counts, chrs, chrs.length - 1, 0, k);
        if (str.isEmpty())
            return "";
        StringBuilder SB = new StringBuilder(str);
        if (mid != '#')
            SB.append(mid);
        SB.append(new StringBuilder(str).reverse());
        return SB.toString();
    }

    public String dfsToRight(int[] counts, char[] chrs, int i, int n, int k) {
        if (i == chrs.length) {
            return new String(chrs);
        }
        for (int j = 'a'; j <= 'z'; j++) {
            if (counts[j] == 0)
                continue;
            counts[j]--;
            long count = 1;
            int sum = n - 1;
            for (int l = 'a'; l <= 'z'; l++) {
                if (counts[l] != 0) {
                    count *= C(sum, counts[l]);
                    sum -= counts[l];
                }
            }
            if (count >= k) {
                chrs[i] = (char) j;
                return dfsToRight(counts, chrs, i + 1, n - 1, k);
            }
            counts[j]++;
            k -= count;
        }
        return "";
    }

    public String dfsToLeft(int[] counts, char[] chrs, int i, int n, int k) {
        if (i == -1)
            return "";
        counts[chrs[i]]++;
        long count = 1;
        int sum = n + 1;
        for (int j = 'a'; j <= 'z'; j++) {
            if (counts[j] != 0) {
                count *= C(sum, counts[j]);
                sum -= counts[j];
            }
        }
        if (count >= k)
            return dfsToRight(counts, chrs, i, n + 1, k);
        return dfsToLeft(counts, chrs, i - 1, n + 1, k);
    }

    public long C(int a, int b) {
        if (a - b < b)
            b = a - b;
        long res = 1;
        for (int i = 1; i <= b; i++) {
            res = res * a / i;
            a--;
        }
        return res;
    }
}
