/*
 * Problem: 3664. Two-Letter Card Game
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/two-letter-card-game/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int score(String[] cards, char x) {
        int[] counts1 = new int['k' - 'a'];
        int count = 0;
        int[] counts2 = new int['k' - 'a'];
        x -= 'a';
        for (String card : cards) {
            int a = card.charAt(0) - 'a';
            int b = card.charAt(1) - 'a';
            if (a == x && b == x) {
                count++;
            } else if (a == x) {
                counts1[b]++;
            } else if (b == x) {
                counts2[a]++;
            }
        }
        int[] pair1 = getPairs(counts1);
        int[] pair2 = getPairs(counts2);
        int sum1 = pair1[0] + pair2[0];
        int sum2 = pair1[1] + pair2[1];

        if (count <= sum2)
            return sum1 + count;
        int res = sum1 + sum2;
        count -= sum2;
        count = count - count % 2;
        if (sum1 * 2 >= count) {
            res += count / 2;
        } else {
            res += sum1;
        }
        return res;
    }

    public int[] getPairs(int[] counts) {
        int sum = 0;
        int max = 0;
        for (int count : counts) {
            sum += count;
            max = Math.max(max, count);
        }
        if (2 * max <= sum) {
            return new int[] { sum / 2, sum % 2 };
        } else {
            return new int[] { sum - max, 2 * max - sum };
        }
    }
}
