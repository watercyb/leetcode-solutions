/*
 * Problem: 1986. Minimum Number of Work Sessions to Finish the Tasks
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int sum=0;
        for (int in:tasks) sum+=in;
        for (int i=sum/sessionTime;i<=tasks.length;i++) {
            if (dfs(new int[i],tasks, sessionTime ,0)) return i;
        }
        return -1;
    }

    public boolean dfs(int[] sessions,int[] tasks, int sessionTime ,int idx) {
        int s=sessions.length;
        for (int i=0;i<s;i++) {
            if (i>0&&sessions[i]==sessions[i-1]) continue;
            if (sessions[i]+tasks[idx]<=sessionTime) {
                if (idx==tasks.length-1) return true;
                sessions[i]+=tasks[idx];
                if (dfs(sessions, tasks, sessionTime, idx+1)) return true;
                sessions[i]-=tasks[idx];
            }
        }
        return false;
    }

}
