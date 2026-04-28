/*
 * Problem: 2561. Rearranging Fruits
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/rearranging-fruits/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Arrays.sort(basket1);
        Arrays.sort(basket2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < basket1.length && j < basket2.length) {
            if (basket1[i] == basket2[j]) {
                i++;
                j++;
            } else if (basket1[i] < basket2[j]) {
                if (i == basket1.length - 1 || basket1[i] != basket1[i + 1])
                    return -1;
                list.add(basket1[i]);
                i += 2;
            } else {
                if (j == basket2.length - 1 || basket2[j] != basket2[j + 1])
                    return -1;
                list.add(basket2[j]);
                j += 2;
            }
        }
        while (i < basket1.length) {
            if (basket1[i] != basket1[i + 1])
                return -1;
            list.add(basket1[i]);
            i += 2;
        }
        while (j < basket2.length) {
            if (basket2[j] != basket2[j + 1])
                return -1;
            list.add(basket2[j]);
            j += 2;
        }
        if (list.isEmpty())
            return 0;
        Collections.sort(list);
        int min = 2 * Math.min(basket1[0], basket2[0]);
        long res = 0;
        for (int k = 0; k < list.size() / 2; k++) {
            res += Math.min(list.get(k), min);
        }
        return res;
    }
}
