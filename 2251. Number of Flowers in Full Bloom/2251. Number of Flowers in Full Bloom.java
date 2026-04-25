/*
 * Problem: 2251. Number of Flowers in Full Bloom
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/number-of-flowers-in-full-bloom/
 * Language: java
 * Date: 2026-04-25
 */

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] blooms = new int[flowers.length];
        int[] fades = new int[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            blooms[i] = flowers[i][0];
            fades[i] = flowers[i][1];
        }
        Arrays.sort(blooms);
        Arrays.sort(fades);
        for (int i = 0; i < people.length; i++) {
            int n1 = BS(blooms, people[i]);
            int n2 = BSB(fades, people[i]);
            people[i] = n1 - n2;

        }
        return people;
    }

    public int BS(int[] flowers, int p) {
        int l = 0;
        int r = flowers.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (flowers[mid] > p) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int BSB(int[] flowers, int p) {
        int l = 0;
        int r = flowers.length;
        while (l < r) {
            int mid = (r - l) / 2 + l;
            if (flowers[mid] >= p) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
