/*
 * Problem: 1053. Previous Permutation With One Swap
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/previous-permutation-with-one-swap/
 * Language: java
 * Date: 2026-04-11
 */

class Solution {
    public int[] prevPermOpt1(int[] arr) {
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int j = i + 1;
                while (j < arr.length - 1 && arr[j + 1] < arr[i]) {
                    j++;
                }
                while (arr[j] == arr[j - 1]) {
                    j--;
                }
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                break;
            }
        }
        return arr;
    }
}
