/*
 * Problem: 2584. Split the Array to Make Coprime Products
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/split-the-array-to-make-coprime-products/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int findValidSplit(int[] nums) {
        if (links == null)
            getArr();
        int[] arr = new int[1000001];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (num > 1) {
                arr[links[num]] = i;
                num /= links[num];
            }
        }
        int r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            while (num > 1) {
                r = Math.max(arr[links[num]], r);
                num /= links[num];
            }
            if (r == i)
                return i;
        }
        return -1;
    }

    static int[] links;

    public void getArr() {
        links = new int[1000001];
        for (int i = 0; i < links.length; i++) {
            links[i] = i;
        }
        for (int i = 2; i <= Math.sqrt(links.length); i++) {
            if (links[i] != i)
                continue;
            for (int j = i * i; j < links.length; j += i) {
                if (links[j] == j)
                    links[j] = i;
            }
        }
    }
}
