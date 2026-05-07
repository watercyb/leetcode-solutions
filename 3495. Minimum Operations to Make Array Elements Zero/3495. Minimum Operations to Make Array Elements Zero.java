/*
 * Problem: 3495. Minimum Operations to Make Array Elements Zero
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public long minOperations(int[][] queries) {
        List<int[]> list = new ArrayList<>();
        long p = 4;
        int n = 1;
        while (p <= 1_000_000_000) {
            list.add(new int[] { (int) p, n });
            p *= 4;
            n++;
        }
        list.add(new int[] { Integer.MAX_VALUE, n });
        int[][] arr = new int[list.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        long res = 0;
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            long count = 0;
            int idx = binarySearch(arr, a);
            while (true) {
                int k = arr[idx][0];
                int v = arr[idx][1];
                if (k > b) {
                    count += (long) (b - a + 1) * v;
                    break;
                } else {
                    count += (long) (k - a) * v;
                }
                a = k;
                idx++;
            }
            res += (count + 1) / 2;
        }
        return res;
    }

    public int binarySearch(int[][] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid][0] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
