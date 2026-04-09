/*
 * Problem: 898. Bitwise ORs of Subarrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/bitwise-ors-of-subarrays/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> HS = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!HS.contains(arr[i]))
                HS.add(arr[i]);
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[j] | arr[i]) == arr[j])
                    break;
                arr[j] = arr[j] | arr[i];
                if (!HS.contains(arr[j]))
                    HS.add(arr[j]);
            }
        }
        return HS.size();
    }
}
