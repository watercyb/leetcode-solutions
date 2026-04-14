/*
 * Problem: 1196. How Many Apples Can You Put into the Basket
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/how-many-apples-can-you-put-into-the-basket/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public int maxNumberOfApples(int[] weight) {
        int[] counts = new int[1001];
        for (int w : weight) {
            counts[w]++;
        }
        int res = 0;
        int sum = 0;
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] != 0) {
                if (sum + counts[i] * i < 5000) {
                    sum += counts[i] * i;
                    res += counts[i];
                } else {
                    res += (5000 - sum) / i;
                    break;
                }
            }
        }
        return res;
    }
}
