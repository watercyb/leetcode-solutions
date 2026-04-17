/*
 * Problem: 1442. Count Triplets That Can Form Two Arrays of Equal XOR
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public int countTriplets(int[] arr) {
        int res = 0;
        HashMap<Integer, int[]> HM = new HashMap<>();
        HM.put(0, new int[] { 1, -1 });
        int XOR = 0;
        for (int i = 0; i < arr.length; i++) {
            XOR ^= arr[i];
            if (HM.containsKey(XOR)) {
                int[] tmp = HM.get(XOR);
                res += (i - 1) * tmp[0] - tmp[1];
                tmp[0]++;
                tmp[1] += i;
            } else {
                int[] tmp = { 1, i };
                HM.put(XOR, tmp);
            }
        }
        return res;
    }
}
