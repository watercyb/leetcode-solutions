/*
 * Problem: 475. Heaters
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/heaters/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0;
        int r = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]);
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (chk(houses, heaters, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean chk(int[] houses, int[] heaters, int mid) {
        int j = 0;
        for (int i = 0; i < heaters.length && j < houses.length && houses[j] >= heaters[i] - mid; i++) {
            while (i < heaters.length - 1 && houses[j] >= heaters[i + 1] - mid) {
                i++;
            }
            while (j < houses.length && houses[j] <= heaters[i] + mid) {
                j++;
            }
        }
        return j == houses.length;
    }
}
