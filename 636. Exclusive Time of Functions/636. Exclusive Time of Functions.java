/*
 * Problem: 636. Exclusive Time of Functions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/exclusive-time-of-functions/
 * Language: java
 * Date: 2026-04-06
 */

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Log> stack = new Stack<>();
        for (String content : logs) {
            Log log = new Log(content);

            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                res[top.id] += log.time - top.time + 1;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= log.time - top.time + 1;
                }
            }
        }

        return res;
    }

    class Log {
        int id;
        boolean isStart;
        int time;

        public Log(String log) {
            String[] parts = log.split(":");
            id = Integer.parseInt(parts[0]);
            isStart = parts[1].equals("start");
            time = Integer.parseInt(parts[2]);
        }
    }
}
