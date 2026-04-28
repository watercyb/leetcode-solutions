/*
 * Problem: 2591. Distribute Money to Maximum Children
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/distribute-money-to-maximum-children/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int distMoney(int money, int children) {
        if (money < children || (children == 1 && money == 4))
            return -1;
        int res = 1;
        while (res <= children) {
            if (money - 8 >= children - res) {
                money -= 8;
                res++;
            } else {
                break;
            }
        }
        if ((res == children && money == 4) || (res == children + 1 && money > 0))
            res--;
        return res - 1;
    }
}
