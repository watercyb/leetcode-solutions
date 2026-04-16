/*
 * Problem: 1333. Filter Restaurants by Vegan-Friendly, Price and Distance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 * Language: java
 * Date: 2026-04-16
 */

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1]
                : b[0] - a[0]);
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice
                    && restaurants[i][4] <= maxDistance)
                PQ.offer(new int[] { restaurants[i][1], restaurants[i][0] });
        }
        List<Integer> res = new ArrayList<>();
        while (!PQ.isEmpty()) {
            res.add(PQ.poll()[1]);
        }
        return res;
    }
}
