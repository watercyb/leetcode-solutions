/*
 * Problem: 1357. Apply Discount Every n Orders
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/apply-discount-every-n-orders/
 * Language: java
 * Date: 2026-04-16
 */

class Cashier {
    int n;
    int discount;
    int[] prices = new int[201];
    int count = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = discount;
        for (int i = 0; i < products.length; i++) {
            this.prices[products[i]] = prices[i];
        }
    }

    public double getBill(int[] product, int[] amount) {
        double res = 0;
        for (int i = 0; i < product.length; i++) {
            res += prices[product[i]] * amount[i];
        }
        if (++count == n) {
            res = res * (100 - discount) / 100;
            count = 0;
        }
        return res;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */
