/*
 * Problem: 989. Add to Array-Form of Integer
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/add-to-array-form-of-integer/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int sum = num[i] + k % 10 + carry;
            res.add(sum % 10);
            carry = sum / 10;
            k /= 10;
        }
        k += carry;
        while (k > 0) {
            res.add(k % 10);
            k /= 10;
        }
        Collections.reverse(res);
        return res;
    }
}
