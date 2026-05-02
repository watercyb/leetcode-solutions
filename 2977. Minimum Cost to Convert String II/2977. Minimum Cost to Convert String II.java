/*
 * Problem: 2977. Minimum Cost to Convert String II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimum-cost-to-convert-string-ii/
 * Language: java
 * Date: 2026-05-02
 */

class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        HashMap<String, Integer> HM = new HashMap<>();
        List<String> idxToStr = new ArrayList<>();
        for (int i = 0; i < original.length; i++) {
            if (!HM.containsKey(original[i])) {
                HM.put(original[i], HM.size());
                idxToStr.add(original[i]);
            }
            if (!HM.containsKey(changed[i])) {
                HM.put(changed[i], HM.size());
                idxToStr.add(changed[i]);
            }
        }
        List<int[]>[] lists = new ArrayList[HM.size()];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < original.length; i++) {
            lists[HM.get(original[i])].add(new int[] { HM.get(changed[i]), cost[i] });
        }
        int[][] costs = new int[lists.length][lists.length];
        int len = source.length();
        List<int[]>[] movesTemp = new ArrayList[len];
        for (int i = 0; i < len; i++) {
            movesTemp[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : HM.entrySet()) {
            boolean has = false;
            String str = entry.getKey();
            int strLen = str.length();
            int id = entry.getValue();
            int idx = source.indexOf(str);
            while (idx >= 0) {
                String strT = target.substring(idx, idx + strLen);
                int idStr = HM.getOrDefault(strT, -1);
                if (idStr >= 0) {
                    has = true;
                    movesTemp[idx].add(new int[] { id, idStr, idx + strLen });
                }
                idx = source.indexOf(str, idx + 1);
            }
            if (!has)
                continue;
            PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            PQ.offer(new int[] { id, 0 });
            while (!PQ.isEmpty()) {
                int[] current = PQ.poll();
                if (costs[id][current[0]] != current[1])
                    continue;
                for (int[] next : lists[current[0]]) {
                    int stp = next[1] + current[1];
                    if (next[0] != id && (costs[id][next[0]] == 0 || costs[id][next[0]] > stp)) {
                        costs[id][next[0]] = stp;
                        PQ.offer(new int[] { next[0], stp });
                    }
                }
            }
        }
        long[] DP = new long[len + 1];
        Arrays.fill(DP, Long.MAX_VALUE / 2);
        DP[0] = 0;
        for (int i = 0; i < len; i++) {
            if (source.charAt(i) == target.charAt(i))
                DP[i + 1] = Math.min(DP[i], DP[i + 1]);
            for (int[] move : movesTemp[i]) {
                int c = costs[move[0]][move[1]];
                if (c != 0)
                    DP[move[2]] = Math.min(DP[i] + c, DP[move[2]]);
            }
        }
        if (DP[DP.length - 1] == Long.MAX_VALUE / 2)
            return -1;
        return DP[DP.length - 1];
    }
}
