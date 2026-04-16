/*
 * Problem: 1360. Number of Days Between Two Dates
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/number-of-days-between-two-dates/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(getInt(date1) - getInt(date2));
    }

    public int getInt(String str) {
        int[] nums1 = { 1971, 1, 1 };
        int[] nums2 = new int[3];
        String[] strs = str.split("-");
        for (int i = 0; i < 3; i++) {
            nums2[i] = Integer.parseInt(strs[i]);
        }
        int res = 0;
        for (int i = nums1[0]; i < nums2[0]; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) {
                res += 366;
            } else {
                res += 365;
            }
        }
        int[] days = { 0, 31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        for (int i = nums1[1]; i < nums2[1]; i++) {
            if (i != 2) {
                res += days[i];
            } else {
                if ((nums2[0] % 4 == 0 && nums2[0] % 100 != 0) || nums2[0] % 400 == 0) {
                    res += 29;
                } else {
                    res += 28;
                }
            }
        }
        res += nums2[2] - nums1[2];
        return res;
    }
}
