/*
 * Problem: 914. X of a Kind in a Deck of Cards
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
 * Language: java
 * Date: 2026-04-10
 */

class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int max = 0;
        for (int num : deck) {
            max = Math.max(num, max);
        }
        int[] counts = new int[max + 1];
        for (int num : deck) {
            counts[num]++;
        }
        int min = Integer.MAX_VALUE;
        for (int count : counts) {
            if (count != 0)
                min = Math.min(count, min);
        }
        if (min == 1)
            return false;
        List<Integer> list = getList(min);
        for (int div : list) {
            if (chk(counts, div))
                return true;
        }
        return false;
    }

    public boolean chk(int[] counts, int div) {
        for (int count : counts) {
            if (count % div != 0)
                return false;
        }
        return true;
    }

    public List<Integer> getList(int num) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                res.add(i);
                num /= i;
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        return res;
    }
}
