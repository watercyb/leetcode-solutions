/*
 * Problem: 2117. Abbreviating the Product of a Range
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/abbreviating-the-product-of-a-range/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public String abbreviateProduct(int left, int right) {
        double a = 1;
        long b = 1;
        boolean isLarge = false;
        int count2 = 0;
        int count5 = 0;
        for (int i = left; i <= right; i++) {
            int num = i;
            while (num % 2 == 0) {
                num /= 2;
                count2++;
            }
            while (num % 5 == 0) {
                num /= 5;
                count5++;
            }
            a *= num;
            while (a > 10)
                a /= 10;
            b *= num;
            if (b >= 10000000000l) {
                isLarge = true;
                b %= 10000000000l;
            }
        }
        int min = Math.min(count2, count5);
        while (count2 > min) {
            a *= 2;
            while (a > 10)
                a /= 10;
            b *= 2;
            if (b >= 10000000000l) {
                isLarge = true;
                b %= 10000000000l;
            }
            count2--;
        }
        while (count5 > min) {
            a *= 5;
            while (a > 10)
                a /= 10;
            b *= 5;
            if (b >= 10000000000l) {
                isLarge = true;
                b %= 10000000000l;
            }
            count5--;
        }
        if (!isLarge)
            return new StringBuilder().append(b).append('e').append(min).toString();
        b %= 100000;
        String str = String.valueOf(b);
        StringBuilder SB = new StringBuilder();
        for (int i = 0; i < 5 - str.length(); i++) {
            SB.append('0');
        }
        SB.append(str);
        str = SB.toString();
        return new StringBuilder().append((int) (a * 10000)).append("...").append(str).append('e').append(min)
                .toString();
    }
}
