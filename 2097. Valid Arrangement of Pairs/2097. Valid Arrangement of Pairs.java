/*
 * Problem: 2097. Valid Arrangement of Pairs
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/valid-arrangement-of-pairs/
 * Language: java
 * Date: 2026-04-23
 */

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        int[] nums = new int[pairs.length + 1];
        for (int[] pair : pairs) {
            if (!HM.containsKey(pair[0])) {
                int idx = HM.size();
                nums[idx] = pair[0];
                HM.put(pair[0], idx);
                pair[0] = idx;
            } else {
                pair[0] = HM.get(pair[0]);
            }
            if (!HM.containsKey(pair[1])) {
                int idx = HM.size();
                nums[idx] = pair[1];
                HM.put(pair[1], idx);
                pair[1] = idx;
            } else {
                pair[1] = HM.get(pair[1]);
            }
        }
        Queue<Integer>[] Qus = new LinkedList[pairs.length + 1];
        int[] counts = new int[pairs.length + 1];
        for (int[] pair : pairs) {
            if (Qus[pair[0]] == null)
                Qus[pair[0]] = new LinkedList<>();
            Qus[pair[0]].offer(pair[1]);
            counts[pair[0]]++;
            counts[pair[1]]--;
        }
        int start = pairs[0][0];
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) {
                start = i;
                break;
            }
        }
        list = new int[pairs.length + 1];
        dfs(Qus, start);
        int[][] res = new int[pairs.length][];
        idx = 0;
        for (int i = list.length - 1; i >= 1; i--) {
            res[idx++] = new int[] { nums[list[i]], nums[list[i - 1]] };
        }
        return res;
    }

    int[] list;
    int idx = 0;

    public void dfs(Queue<Integer>[] Qus, int i) {
        if (Qus[i] != null) {
            while (!Qus[i].isEmpty()) {
                dfs(Qus, Qus[i].poll());
            }
        }
        list[idx++] = i;
    }
}
