/*
 * Problem: 1345. Jump Game IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/jump-game-iv/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int minJumps(int[] arr) {
        if (arr.length == 1)
            return 0;
        HashMap<Integer, List<Integer>> HM = new HashMap<>();
        int[] stps = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i < arr.length - 1 && arr[i - 1] == arr[i] && arr[i] == arr[i + 1])
                continue;
            List<Integer> tmp = HM.getOrDefault(arr[i], new ArrayList<>());
            tmp.add(i);
            HM.put(arr[i], tmp);
        }
        Queue<Integer> Qu = new LinkedList<>();
        Qu.add(0);
        stps[0] = 1;
        while (!Qu.isEmpty()) {
            int stp = Qu.poll();
            if (stp - 1 >= 0 && stps[stp - 1] == 0) {
                Qu.add(stp - 1);
                stps[stp - 1] = stps[stp] + 1;
            }
            if (stp + 1 < arr.length && stps[stp + 1] == 0) {
                if (stp + 1 == arr.length - 1)
                    return stps[stp];
                Qu.add(stp + 1);
                stps[stp + 1] = stps[stp] + 1;
            }
            for (int in : HM.get(arr[stp])) {
                if (in >= 0 && stps[in] == 0) {
                    if (in == arr.length - 1)
                        return stps[stp];
                    Qu.add(in);
                    stps[in] = stps[stp] + 1;
                }
            }
            HM.put(arr[stp], new ArrayList<>());
        }
        return -1;
    }
}
