/*
 * Problem: 2332. The Latest Time to Catch a Bus
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-latest-time-to-catch-a-bus/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int j = 0;
        int count = 0;
        for (int i = 0; i < buses.length - 1; i++) {
            while (j < passengers.length && passengers[j] <= buses[i] && count < capacity) {
                j++;
                count++;
            }
            count = 0;
            if (j == passengers.length)
                return buses[buses.length - 1];
        }
        while (j < passengers.length && passengers[j] <= buses[buses.length - 1] && count < capacity) {
            j++;
            count++;
        }
        if ((count == capacity || (j > 0 && passengers[j - 1] == buses[buses.length - 1]))) {
            for (int k = j - 1; k >= 1; k--) {
                if (passengers[k] != passengers[k - 1] + 1)
                    return passengers[k] - 1;
            }
            return passengers[0] - 1;
        }
        return buses[buses.length - 1];
    }
}
