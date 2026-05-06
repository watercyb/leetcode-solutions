/*
 * Problem: 3395. Subsequences with a Unique Middle Mode I
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/subsequences-with-a-unique-middle-mode-i/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {

    int mod = 1_000_000_007;

    public int subsequencesWithMiddleMode(int[] nums) {
        HashMap<Integer, Integer> HM = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!HM.containsKey(nums[i])) {
                int v = HM.size();
                HM.put(nums[i], v);
                nums[i] = v;
            } else {
                nums[i] = HM.get(nums[i]);
            }
        }
        int[] counts = new int[HM.size()];
        int count = 0;
        for (int num : nums) {
            if (counts[num]++ == 1)
                count++;
        }
        int[] lefts = new int[counts.length];
        int[] rights = counts.clone();
        lefts[nums[0]]++;
        lefts[nums[1]]++;
        rights[nums[0]]--;
        rights[nums[1]]--;
        int[] arr = new int[count];
        int idx = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 1)
                arr[idx++] = i;
        }
        long countLeft = 2;
        long countRight = nums.length - 2;
        long res = 0;
        for (int i = 2; i < nums.length - 2; i++) {
            countRight--;
            rights[nums[i]]--;
            int countCurrentRight = rights[nums[i]];
            res += countLeft * (countLeft - 1) * countRight * (countRight - 1) / 4;
            long countCurrentLeft = lefts[nums[i]];
            long countLeftWoCurrent = countLeft - countCurrentLeft;
            long countRightWoCurrent = countRight - countCurrentRight;
            res -= countLeftWoCurrent * (countLeftWoCurrent - 1)
                    * countRightWoCurrent * (countRightWoCurrent - 1) / 4;
            for (int num : arr) {
                if (num == nums[i])
                    continue;
                int vLeft = lefts[num];
                int vRight = rights[num];
                if (countCurrentLeft > 0)
                    res = (res - countCurrentLeft * (vLeft * vRight * (countRightWoCurrent - vRight)
                            + countLeftWoCurrent * vRight * (vRight - 1) / 2)) % mod;
                if (countCurrentRight > 0)
                    res = (res - countCurrentRight * (vLeft * (vLeft - 1) / 2 * countRightWoCurrent
                            + vLeft * (countLeftWoCurrent - vLeft) * vRight)) % mod;
            }
            countLeft++;
            lefts[nums[i]]++;
        }
        return (int) ((res + mod) % mod);
    }
}
