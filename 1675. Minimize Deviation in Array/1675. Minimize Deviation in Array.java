/*
 * Problem: 1675. Minimize Deviation in Array
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/minimize-deviation-in-array/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public int minimumDeviation(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while ((num & 1) == 0) {
                num /= 2;
            }
            max = Math.max(num, max);
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            int canMultiple = (nums[i] & 1) == 1 ? 1 : 0;
            while (nums[i] > max) {
                nums[i] /= 2;
                canMultiple = 1;
            }
            PQ.offer(new int[] { nums[i], canMultiple });
        }
        int[] min = PQ.peek();
        int res = max - min[0];
        if (min[1] == 0)
            return res;
        int target = min[0] * 2;
        PQ.offer(new int[] { target, 0 });
        for (int i = 0; i < nums.length - 1; i++) {
            int[] num = PQ.poll();
            if (num[1] == 0 || num[0] == target) {
                res = Math.min(max - min[0], res);
                break;
            }
            num[0] *= 2;
            max = Math.max(num[0], max);
            min = PQ.peek();
            res = Math.min(max - min[0], res);
        }
        return res;
    }
}
