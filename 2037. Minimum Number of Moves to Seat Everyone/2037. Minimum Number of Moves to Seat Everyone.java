/*
 * Problem: 2037. Minimum Number of Moves to Seat Everyone
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        CountingSort(seats);
        CountingSort(students);
        int res = 0;
        for (int i = 0; i < seats.length; i++) {
            res += Math.abs(students[i] - seats[i]);
        }
        return res;
    }

    public void CountingSort(int[] arr) {
        int[] counts = new int[101];
        for (int num : arr) {
            counts[num]++;
        }
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            while (counts[idx] == 0) {
                idx++;
            }
            arr[i] = idx;
            counts[idx]--;
        }
    }
}
