/*
 * Problem: 4030. Elevator Requests IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/elevator-requests-iv/
 * Language: java
 * Date: 2026-08-19
 */

class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int[] request : requests) {
            HM.put(request[1], Math.max(request[0], HM.getOrDefault(request[1], request[0])));
        }
        int[][] arr = new int[HM.size() + 1][];
        arr[0] = new int[] { 0, start };
        int idx = 1;
        for (Map.Entry<Integer, Integer> entry : HM.entrySet()) {
            arr[idx++] = new int[] { entry.getValue(), entry.getKey() };
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        meme = new long[arr.length][arr.length];
        for (long[] row : meme) {
            Arrays.fill(row, Long.MAX_VALUE / 2);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][0] == 0 && arr[i][1] == start) {
                return Math.min(dfsLeft(arr, i), dfsRight(arr, i));
            }
        }
        return -1;
    }

    long[][] meme;

    public long dfsLeft(int[][] arr, int idx) {
        HashSet<Long> HS = new HashSet<>();
        long min = Math.max(arr[0][0], Math.abs(arr[idx][1] - arr[0][1]));
        HS.add(min);
        for (int i = idx; i >= 0; i--) {
            long t = arr[i][0] + arr[i][1] - arr[0][1];
            if (t > min)
                HS.add(t);
        }
        long res = Long.MAX_VALUE;
        for (long t : HS) {
            boolean[] seens = new boolean[arr.length];
            int first = -1;
            for (int i = idx; i >= 0; i--) {
                if (arr[i][0] <= t - (arr[i][1] - arr[0][1])) {
                    seens[i] = true;
                } else if (first == -1) {
                    first = i;
                }
            }
            if (seens[arr.length - 1]) {
                if (first == -1) {
                    res = Math.min(res, t);
                } else {
                    res = Math.min(res, dfs(arr, seens, 0, first, t));
                }
            } else {
                res = Math.min(res, dfs(arr, seens, 0, arr.length - 1, t));
            }
        }
        return res;
    }

    public long dfsRight(int[][] arr, int idx) {
        HashSet<Long> HS = new HashSet<>();
        long min = Math.max(arr[arr.length - 1][0], Math.abs(arr[arr.length - 1][1] - arr[idx][1]));
        HS.add(min);
        for (int i = idx; i < arr.length; i++) {
            long t = arr[i][0] + arr[arr.length - 1][1] - arr[i][1];
            if (t > min)
                HS.add(t);
        }
        long res = Long.MAX_VALUE;
        for (long t : HS) {
            boolean[] seens = new boolean[arr.length];
            int first = -1;
            for (int i = idx; i < arr.length; i++) {
                if (arr[i][0] <= t - (arr[arr.length - 1][1] - arr[i][1])) {
                    seens[i] = true;
                } else if (first == -1) {
                    first = i;
                }
            }
            if (seens[0]) {
                if (first == -1) {
                    res = Math.min(res, t);
                } else {
                    res = Math.min(res, dfs(arr, seens, arr.length - 1, first, t));
                }
            } else {
                res = Math.min(res, dfs(arr, seens, arr.length - 1, 0, t));
            }
        }
        return res;
    }

    public long dfs(int[][] requests, boolean[] seens, int a, int b, long time) {
        if (meme[a][b] <= time)
            return Long.MAX_VALUE / 2;
        meme[a][b] = time;
        HashSet<Long> HS = new HashSet<>();
        long min = Math.max(requests[b][0], time + Math.abs(requests[a][1] - requests[b][1]));
        HS.add(min);
        if (a < b) {
            for (int i = a; i < b; i++) {
                if (!seens[i]) {
                    long t = requests[i][0] + requests[b][1] - requests[i][1];
                    if (t > min)
                        HS.add(t);
                }
            }
        } else {
            for (int i = a; i > b; i--) {
                if (!seens[i]) {
                    long t = requests[i][0] + requests[i][1] - requests[b][1];
                    if (t > min)
                        HS.add(t);
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (long t : HS) {
            boolean[] seensNext = seens.clone();
            int first = -1;
            if (a < b) {
                for (int i = a; i < b; i++) {
                    if (seensNext[i])
                        continue;
                    if (requests[i][0] <= t - (requests[b][1] - requests[i][1])) {
                        seensNext[i] = true;
                    } else if (first == -1) {
                        first = i;
                    }
                }
            } else {
                for (int i = a; i > b; i--) {
                    if (seensNext[i])
                        continue;
                    if (requests[i][0] <= t - (requests[i][1] - requests[b][1])) {
                        seensNext[i] = true;
                    } else if (first == -1) {
                        first = i;
                    }
                }
            }
            if (first == -1) {
                res = Math.min(res, t);
            } else {
                res = Math.min(res, dfs(requests, seensNext, b, first, t));
            }
        }
        return res;
    }
}
