/*
 * Problem: 4023. Elevator Requests II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/elevator-requests-ii/
 * Language: java
 * Date: 2026-08-18
 */

class Solution {
    public long elevatorRequests(int n, int start, int[] requests) {
        Arrays.sort(requests);
        long res = 0;
        if (start <= requests[0]) {
            long count = requests.length;
            for (int request : requests) {
                res += count * (request - start);
                count--;
                start = request;
            }
            return res;
        }
        if (start >= requests[requests.length - 1]) {
            long count = requests.length;
            for (int request : requests) {
                res += count * (start - request);
                count--;
                start = request;
            }
            return res;
        }
        int l = 0;
        int r = requests.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (requests[mid] >= start) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        long[][] DP = new long[requests.length + 2][requests.length + 2];
        for (long[] row : DP) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        if (requests[l] == start) {
            DP[l + 1][l] = 0;
            DP[l + 1][l + 2] = 0;
        } else {
            DP[l][l + 1] = (long) requests.length * (start - requests[l - 1]);
            DP[l + 1][l] = (long) requests.length * (requests[l] - start);
            l--;
        }
        for (int i = l; i >= 0; i--) {
            for (int j = i + 2; j <= requests.length; j++) {
                long count = (long) (requests.length - j + i + 1);
                DP[i + 1][j + 1] = Math.min(
                        DP[i + 2][j + 1] + count * (requests[i + 1] - requests[i]),
                        DP[j][i + 1] + count * (requests[j - 1] - requests[i]));
                if (j < requests.length) {
                    DP[j + 1][i + 1] = Math.min(
                            DP[i + 2][j + 1] + count * (requests[j] - requests[i + 1]),
                            DP[j][i + 1] + count * (requests[j] - requests[j - 1]));
                }
            }
        }
        int i = -1;
        for (int j = 1; j < requests.length; j++) {
            DP[j + 1][i + 1] = Math.min(
                    DP[i + 2][j + 1] + (long) (requests.length - j + i + 1) * (requests[j] - requests[i + 1]),
                    DP[j][i + 1] + (long) (requests.length - j + i + 1) * (requests[j] - requests[j - 1]));
        }
        return Math.min(DP[1][requests.length + 1], DP[requests.length][0]);
    }
}
