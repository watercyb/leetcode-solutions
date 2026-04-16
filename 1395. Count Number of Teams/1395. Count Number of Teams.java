/*
 * Problem: 1395. Count Number of Teams
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-number-of-teams/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int numTeams(int[] rating) {
        int max = 0;
        for (int rate : rating) {
            max = Math.max(rate, max);
        }
        BIT bit = new BIT(max + 1);
        int[] smaller = new int[rating.length];
        int[] larger = new int[rating.length];
        for (int i = 0; i < rating.length; i++) {
            smaller[i] = bit.get(rating[i]);
            larger[i] = i - smaller[i];
            bit.insert(rating[i]);
        }
        bit = new BIT(max + 1);
        int res = 0;
        for (int i = rating.length - 1; i >= 0; i--) {
            int count = bit.get(rating[i]);
            res += larger[i] * count + smaller[i] * (rating.length - 1 - i - count);
            bit.insert(rating[i]);
        }
        return res;
    }
}

class BIT {
    int[] bit;

    public BIT(int n) {
        bit = new int[n + 1];
    }

    public void insert(int i) {
        i++;
        while (i < bit.length) {
            bit[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        i++;
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= i & -i;
        }
        return res;
    }
}
