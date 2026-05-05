/*
 * Problem: 3265. Count Almost Equal Pairs I
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-almost-equal-pairs-i/
 * Language: java
 * Date: 2026-05-05
 */

class Solution {
    public int countPairs(int[] nums) {
        int[] bases = { 1, 10, 100, 1000, 10000, 100000, 1000000 };
        HashMap<Integer, Integer> HM = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            int count = HM.getOrDefault(num, 0);
            res += count;
            HM.put(num, count + 1);
            int[] arr = new int[7];
            int numTemp = num;
            for (int i = 0; i < 7 && numTemp > 0; i++) {
                arr[i] = numTemp % 10;
                numTemp /= 10;
            }
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 7; j++) {
                    if (arr[i] == arr[j])
                        continue;
                    numTemp = num + (arr[i] - arr[j]) * (bases[j] - bases[i]);
                    HM.put(numTemp, HM.getOrDefault(numTemp, 0) + 1);
                }
            }
        }
        return res;
    }
}
