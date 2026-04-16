/*
 * Problem: 1386. Cinema Seat Allocation
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/cinema-seat-allocation/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int h = HM.getOrDefault(reservedSeat[0], 0) | getH(reservedSeat[1]);
            HM.put(reservedSeat[0], h);
        }
        int res = (n - HM.size()) * 2;
        for (int h : HM.values()) {
            if ((h & 3) == 0) {
                res += 2;
            } else if (Integer.bitCount(h) < 3) {
                res++;
            }
        }
        return res;
    }

    public int getH(int num) {
        int res = 0;
        if (num >= 2 && num <= 5) {
            res |= 1;
        } else if (num >= 6 && num <= 9) {
            res |= 2;
        }
        if (num >= 4 && num <= 7)
            res |= 4;
        return res;
    }
}
