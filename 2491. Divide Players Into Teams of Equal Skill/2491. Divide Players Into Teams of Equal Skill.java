/*
 * Problem: 2491. Divide Players Into Teams of Equal Skill
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/
 * Language: java
 * Date: 2026-04-27
 */

class Solution {
    public long dividePlayers(int[] skill) {
        int[] counts = new int[2001];
        int sum = 0;
        for (int num : skill) {
            sum += num;
            counts[num]++;
        }
        if (sum % (skill.length / 2) != 0)
            return -1;
        int target = sum / (skill.length / 2);
        for (int i = target; i <= 2000; i++) {
            if (counts[i] > 0)
                return -1;
        }
        long res = 0;
        for (int i = 1; i < (target + 1) / 2; i++) {
            if (counts[i] != counts[target - i])
                return -1;
            res += (long) counts[i] * i * (target - i);
        }
        if (target % 2 == 0)
            res += (long) counts[target / 2] * target * target / 8;
        return res;
    }
}
