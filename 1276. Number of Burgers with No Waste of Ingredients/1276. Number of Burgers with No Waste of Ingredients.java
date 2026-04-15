/*
 * Problem: 1276. Number of Burgers with No Waste of Ingredients
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices == 0 && cheeseSlices == 0)
            return List.of(0, 0);
        if (tomatoSlices % 2 == 1 || cheeseSlices == 0 || (tomatoSlices + cheeseSlices - 1) / cheeseSlices > 4
                || tomatoSlices / cheeseSlices < 2)
            return new ArrayList<>();
        return List.of(tomatoSlices / 2 - cheeseSlices, cheeseSlices * 2 - tomatoSlices / 2);
    }
}
