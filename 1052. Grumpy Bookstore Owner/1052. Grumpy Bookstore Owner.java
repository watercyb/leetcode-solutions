/*
 * Problem: 1052. Grumpy Bookstore Owner
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/grumpy-bookstore-owner/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sumCustomer = 0;
        int sumUnsatisfied = 0;
        int sumUnderTech = 0;
        int max = 0;
        for (int i = 0; i < minutes; i++) {
            sumCustomer += customers[i];
            customers[i] *= grumpy[i];
            sumUnsatisfied += customers[i];
            sumUnderTech += customers[i];
        }
        max = Math.max(sumUnderTech, max);
        int j = 0;
        for (int i = minutes; i < customers.length; i++) {
            sumCustomer += customers[i];
            customers[i] *= grumpy[i];
            sumUnsatisfied += customers[i];
            sumUnderTech += customers[i] - customers[j];
            if (sumUnderTech > max)
                max = sumUnderTech;
            j++;
        }
        return sumCustomer - sumUnsatisfied + max;
    }
}
