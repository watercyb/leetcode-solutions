/*
 * Problem: 2241. Design an ATM Machine
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-an-atm-machine/
 * Language: java
 * Date: 2026-04-25
 */

class ATM {
    int[] arr = { 20, 50, 100, 200, 500 };
    int[] counts = new int[5];

    public ATM() {

    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++) {
            counts[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] res = new int[5];
        for (int i = 4; i >= 0; i--) {
            if (counts[i] > 0 && amount >= arr[i]) {
                int n = Math.min(amount / arr[i], counts[i]);
                amount -= n * arr[i];
                res[i] += n;
            }
        }
        if (amount > 0)
            return new int[] { -1 };
        for (int i = 0; i < 5; i++) {
            counts[i] -= res[i];
        }
        return res;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */
