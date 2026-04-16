/*
 * Problem: 1352. Product of the Last K Numbers
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/product-of-the-last-k-numbers/
 * Language: java
 * Date: 2026-04-16
 */

class ProductOfNumbers {
    int[] arr = new int[40001];
    int idx = 1;

    public ProductOfNumbers() {
        arr[0] = 1;
    }

    public void add(int num) {
        if (num == 0) {
            idx = 1;
        } else {
            arr[idx] = arr[idx - 1] * num;
            idx++;
        }
    }

    public int getProduct(int k) {
        if (idx - k - 1 < 0)
            return 0;
        return arr[idx - 1] / arr[idx - k - 1];
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
