/*
 * Problem: 3348. Smallest Divisible Digit Product II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/smallest-divisible-digit-product-ii/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public String smallestNumber(String num, long t) {
        int[] counts = new int[4];
        while (t > 1 && t % 2 == 0) {
            counts[0]++;
            t /= 2;
        }
        while (t > 1 && t % 3 == 0) {
            counts[1]++;
            t /= 3;
        }
        while (t > 1 && t % 5 == 0) {
            counts[2]++;
            t /= 5;
        }
        while (t > 1 && t % 7 == 0) {
            counts[3]++;
            t /= 7;
        }
        if (t > 1)
            return "-1";
        String min = getMin(counts);
        if (min.length() > num.length() || (min.length() == num.length() && min.compareTo(num) >= 0))
            return min;
        String minSuffix = getMinSuffix(num, counts);
        if (minSuffix != null)
            return minSuffix;
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i <= num.length() - min.length(); i++) {
            SB.append('1');
        }
        return SB.append(min).toString();
    }

    public void getSuffix(int[] counts, char[] res, int len) {
        int[] digitCounts = new int[10];
        int count2 = counts[0];
        int count3 = counts[1];
        int count5 = counts[2];
        int count7 = counts[3];
        digitCounts[5] = count5;
        digitCounts[7] = count7;
        digitCounts[8] = count2 / 3;
        count2 %= 3;
        if (count3 % 2 == 1 && count2 > 0) {
            count2--;
            count3--;
            digitCounts[6] = 1;
        }
        digitCounts[4] = count2 / 2;
        count2 %= 2;
        digitCounts[9] = count3 / 2;
        count3 %= 2;
        digitCounts[2] = count2;
        digitCounts[3] = count3;
        int idx = res.length - 1;
        for (int i = 9; i >= 2; i--) {
            for (int j = 0; j < digitCounts[i]; j++) {
                res[idx--] = (char) (i + '0');
            }
        }
        while (idx > len) {
            res[idx--] = '1';
        }
    }

    public int getLen(int[] counts) {
        int count2 = counts[0] > 0 ? counts[0] : 0;
        int count3 = counts[1] > 0 ? counts[1] : 0;
        int count5 = counts[2] > 0 ? counts[2] : 0;
        int count7 = counts[3] > 0 ? counts[3] : 0;
        int res = 0;
        res += count5;
        res += count7;
        res += count2 / 3;
        count2 %= 3;
        if (count3 % 2 == 1 && count2 > 0) {
            count2--;
            count3--;
            res += 1;
        }
        res += count2 / 2;
        count2 %= 2;
        res += count3 / 2;
        count3 %= 2;
        res += count2;
        res += count3;
        return res;
    }

    public String getMinSuffix(String num, int[] counts) {
        char[] chrs = num.toCharArray();
        int zeroIdx = chrs.length;
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '0') {
                zeroIdx = i;
                break;
            }
            change(counts, chrs[i] - '0', -1);
        }
        if (zeroIdx == chrs.length && counts[0] <= 0 && counts[1] <= 0 && counts[2] <= 0 && counts[3] <= 0)
            return num;
        char[] res = chrs;
        for (int i = Math.min(chrs.length - 1, zeroIdx); i >= 0; i--) {
            change(counts, chrs[i] - '0', 1);
            for (int j = chrs[i] - '0' + 1; j <= 9; j++) {
                res[i]++;
                change(counts, j, -1);
                if (getLen(counts) < chrs.length - i) {
                    getSuffix(counts, res, i);
                    return new String(res);
                }
                change(counts, j, 1);
            }
        }
        return null;
    }

    public void change(int[] counts, int n, int p) {
        switch (n) {
            case 2:
                counts[0] += p;
                break;
            case 3:
                counts[1] += p;
                break;
            case 4:
                counts[0] += 2 * p;
                break;
            case 5:
                counts[2] += p;
                break;
            case 6:
                counts[0] += p;
                counts[1] += p;
                break;
            case 7:
                counts[3] += p;
                break;
            case 8:
                counts[0] += 3 * p;
                break;
            case 9:
                counts[1] += 2 * p;
                break;
        }
    }

    public String getMin(int[] counts) {
        int[] digitCounts = new int[10];
        int count2 = counts[0] > 0 ? counts[0] : 0;
        int count3 = counts[1] > 0 ? counts[1] : 0;
        int count5 = counts[2] > 0 ? counts[2] : 0;
        int count7 = counts[3] > 0 ? counts[3] : 0;
        digitCounts[5] = count5;
        digitCounts[7] = count7;
        digitCounts[8] = count2 / 3;
        count2 %= 3;
        if (count3 % 2 == 1 && count2 > 0) {
            count2--;
            count3--;
            digitCounts[6] = 1;
        }
        digitCounts[4] = count2 / 2;
        count2 %= 2;
        digitCounts[9] = count3 / 2;
        count3 %= 2;
        digitCounts[2] = count2;
        digitCounts[3] = count3;
        StringBuilder SB = new StringBuilder();
        for (int i = 2; i <= 9; i++) {
            for (int j = 0; j < digitCounts[i]; j++) {
                SB.append((char) (i + '0'));
            }
        }
        return SB.toString();
    }
}
