/*
 * Problem: 4042. Valid K-Unique Subarrays II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/valid-k-unique-subarrays-ii/
 * Language: java
 * Date: 2026-09-01
 */

class Solution {
    public boolean[] validSubarrays(int[] nums, int k, int l0, int r0, int q) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] lefts = new int[nums.length];
        int[] rights = new int[nums.length];
        int l = -1;
        int r = -1;
        int[] leftCounts = new int[max + 1];
        int[] rightCounts = new int[max + 1];
        int leftCount = 0;
        int rightCount = 0;
        HashMap<Integer, Integer> HM = new HashMap<>();
        Random rand = new Random();
        int[] xors = new int[nums.length + 1];
        int xor = 0;
        HashSet<Integer> HS = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            while (leftCount < k) {
                if (l >= nums.length - 1) {
                    l = nums.length;
                    break;
                }
                if (leftCounts[nums[++l]]++ == 0)
                    leftCount++;
            }
            lefts[i] = l;
            while (rightCount <= k) {
                if (r >= nums.length - 1) {
                    r = nums.length;
                    break;
                }
                if (rightCounts[nums[++r]]++ == 0)
                    rightCount++;
            }
            rights[i] = r;
            if (leftCounts[nums[i]]-- == 1)
                leftCount--;
            if (rightCounts[nums[i]]-- == 1)
                rightCount--;
            Integer h = HM.getOrDefault(nums[i], null);
            if (h == null) {
                h = rand.nextInt();
                while (!HS.add(h)) {
                    h = rand.nextInt();
                }
                HM.put(nums[i], h);
            }
            xor ^= h;
            xors[i + 1] = xor;
        }
        boolean[] res = new boolean[q];
        for (int i = 0; i < q; i++) {
            int g;
            if (lefts[l0] <= r0 && rights[l0] >= r0 && (xors[l0] ^ xors[r0 + 1]) == 0) {
                res[i] = true;
                g = l0 + r0;
            } else {
                g = r0 - l0;
            }
            l0 = (l0 ^ g) % nums.length;
            r0 = (r0 ^ g) % nums.length;
            if (l0 > r0) {
                int temp = l0;
                l0 = r0;
                r0 = temp;
            }
        }
        return res;
    }
}
