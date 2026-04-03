/*
 * Problem: 401. Binary Watch
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-watch/
 * Language: java
 * Date: 2026-04-03
 */

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String>[] H = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            H[i] = new ArrayList<>();
        }
        List<String>[] M = new ArrayList[7];
        for (int i = 0; i < 7; i++) {
            M[i] = new ArrayList<>();
        }
        DFS1(H, 0, 0, 0);
        DFS2(M, 0, 0, 0);
        List<String> res = new ArrayList<>();
        for (int i = Math.max(0, turnedOn - 6); i < 4; i++) {
            if (i > turnedOn)
                break;
            for (String strH : H[i]) {
                for (String strM : M[turnedOn - i]) {
                    res.add(strH + strM);
                }
            }
        }
        return res;
    }

    public void DFS1(List<String>[] Li, int sum, int i, int stp) {
        if (i == 3) {
            Li[stp].add(String.valueOf(sum));
            int tmp = sum + (1 << i);
            if (tmp < 12)
                Li[stp + 1].add(String.valueOf(tmp));
        } else {
            DFS1(Li, sum, i + 1, stp);
            DFS1(Li, sum + (1 << i), i + 1, stp + 1);
        }
    }

    public void DFS2(List<String>[] Li, int sum, int i, int stp) {
        if (i == 5) {
            if (sum < 60) {
                if (sum < 10) {
                    Li[stp].add(":0" + String.valueOf(sum));
                } else {
                    Li[stp].add(":" + String.valueOf(sum));
                }
            }
            int tmp = sum + (1 << i);
            if (tmp < 60) {
                if (tmp < 10) {
                    Li[stp + 1].add(":0" + String.valueOf(tmp));
                } else {
                    Li[stp + 1].add(":" + String.valueOf(tmp));
                }
            }
        } else {
            DFS2(Li, sum, i + 1, stp);
            int tmp = sum + (1 << i);
            if (tmp < 60)
                DFS2(Li, sum + (1 << i), i + 1, stp + 1);
        }
    }
}
