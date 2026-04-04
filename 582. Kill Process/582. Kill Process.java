/*
 * Problem: 582. Kill Process
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/kill-process/
 * Language: java
 * Date: 2026-04-04
 */

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, List<Integer>> links = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            int id = pid.get(i);
            int p = ppid.get(i);
            if (p == 0 && id == kill)
                return pid;
            List<Integer> tmp = links.getOrDefault(p, new ArrayList<>());
            tmp.add(id);
            links.put(p, tmp);
        }
        List<Integer> res = new ArrayList<>();
        dfs(links, res, kill);
        return res;
    }

    public void dfs(HashMap<Integer, List<Integer>> links, List<Integer> res, int i) {
        res.add(i);
        for (int next : links.getOrDefault(i, new ArrayList<>())) {
            dfs(links, res, next);
        }
    }
}
