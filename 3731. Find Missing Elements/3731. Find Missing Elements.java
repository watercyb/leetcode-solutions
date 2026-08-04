/*
 * Problem: 3731. Find Missing Elements
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/find-missing-elements/?envType=daily-question&envId=2026-08-04
 * Language: java
 * Date: 2026-08-04
 */

class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        boolean[] seens = new boolean[101];
        int max = -1;
        int min = 101;
        for (int num : nums) {
            seens[num] = true;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = min + 1; i < max; i++) {
            if (!seens[i])
                res.add(i);
        }
        return res;
    }
}
