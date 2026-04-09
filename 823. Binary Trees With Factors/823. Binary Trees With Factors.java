/*
 * Problem: 823. Binary Trees With Factors
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/binary-trees-with-factors/
 * Language: java
 * Date: 2026-04-09
 */

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        Arrays.sort(arr);
        int max = arr[arr.length - 1];
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int in : arr) {
            HM.put(in, 1);
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                long pro = (long)arr[i] * arr[j];
                if (pro > max)
                    break;
                if (!HM.containsKey((int) pro))
                    continue;
                PQ.add(new int[] { i, j, (int) pro });
            }
        }
        while (!PQ.isEmpty()) {
            int[] tmp = PQ.poll();
            if (tmp[0] == tmp[1]) {
                HM.put(tmp[2], (int) (((long) HM.get(arr[tmp[0]]) * HM.get(arr[tmp[1]]) + HM.get(tmp[2])) % mod));
            } else {
                HM.put(tmp[2], (int) (((long) HM.get(arr[tmp[0]]) * HM.get(arr[tmp[1]]) * 2 + HM.get(tmp[2])) % mod));
            }
        }
        long res = 0;
        for (int in : HM.values()) {
            res = (res + in) % mod;
        }
        return (int) res;
    }
}
