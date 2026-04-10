/*
 * Problem: 937. Reorder Data in Log Files
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/reorder-data-in-log-files/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        PriorityQueue<String[]> PQ = new PriorityQueue<>(
                (a, b) -> !a[0].equals(b[0]) ? a[0].compareTo(b[0]) : a[1].compareTo(b[1]));
        String[] res = new String[logs.length];
        int idx = logs.length - 1;
        for (int i = idx; i >= 0; i--) {
            int j = logs[i].indexOf(" ");
            if (Character.isLowerCase(logs[i].charAt(j + 1))) {
                PQ.offer(new String[] { logs[i].substring(j), logs[i] });
            } else {
                res[idx--] = logs[i];
            }
        }
        idx = 0;
        while (!PQ.isEmpty()) {
            String[] str = PQ.poll();
            res[idx++] = str[1];
        }
        return res;
    }
}
