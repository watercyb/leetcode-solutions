/*
 * Problem: 3747. Count Distinct Integers After Removing Zeros
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-distinct-integers-after-removing-zeros/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long countDistinct(long n) {
        char[] chrs = String.valueOf(n).toCharArray();
        long count = 0;
        boolean isGood = true;
        for (int i = 0; i < chrs.length; i++) {
            int digit = chrs[i] - '0';
            if (digit == 0)
                isGood = false;
            if (i > 0)
                count += 1;
            count *= 9;
            if (isGood)
                count += digit - 1;
        }
        if (isGood)
            count++;
        return count;
    }
}
