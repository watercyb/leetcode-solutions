/*
 * Problem: 1353. Maximum Number of Events That Can Be Attended
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int[] nextAvaible=new int[events[events.length-1][1]+2];
        for (int i=0;i<nextAvaible.length;i++) {
            nextAvaible[i]=i;
        }

        int res=0;
        for (int[] event:events) {
            int next=findNextAvaible(nextAvaible, event[0]);
            if (next<=event[1]) {
                res++;
                nextAvaible[next]=next+1;
            }
            
        }
        return res;

    }

    public int findNextAvaible(int[] nextAvaible, int n){
        if (nextAvaible[n]!=n) {
            nextAvaible[n]=findNextAvaible(nextAvaible, nextAvaible[n]);

        }
        return nextAvaible[n];
    }

}
