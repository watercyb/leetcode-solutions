/*
 * Problem: 2125. Number of Laser Beams in a Bank
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-laser-beams-in-a-bank/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public int numberOfBeams(String[] bank) {
        int res=0;
        int prvRow=0;
        for (String str : bank) {
            int thisRow=0;
            for (char chr : str.toCharArray()) {
                if (chr=='1') thisRow++;
            }
            if (thisRow>0) {
                res+=prvRow*thisRow;
                prvRow=thisRow;
            }
        }
        return res;
    }
}
