/*
 * Problem: 3366. Minimum Array Sum
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/minimum-array-sum/
 * Language: java
 * Date: 2026-05-06
 */

class Solution {
    public int minArraySum(int[] nums, int k, int op1, int op2) {
        Arrays.sort(nums);
        int res = 0;
        int r = nums.length - 1;
        while (r >= 0 && op1 > 0 && op2 > 0) {
            if ((nums[r] + 1) / 2 >= k) {
                res += (nums[r] + 1) / 2 - k;
                op1--;
                op2--;
                r--;
            } else {
                break;
            }
        }
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
        PriorityQueue<Integer> PQ1 = new PriorityQueue<>((a, b) -> b - a);
        int l = 0;
        while (l <= r) {
            if (nums[l] < k) {
                PQ.offer(new int[] { nums[l], -1 });
            } else if (k % 2 == 1 && nums[l] % 2 == 0) {
                if (op2 > 0) {
                    PQ1.offer(nums[l] - k);
                    op2--;
                } else {
                    PQ.offer(new int[] { nums[l], -1 });
                }
            } else {
                if (op2 > 0) {
                    PQ.offer(new int[] { nums[l] - k, -1 });
                    op2--;
                } else {
                    PQ.offer(new int[] { nums[l], 0 });
                }
            }
            l++;
        }
        int count = 0;
        while (!PQ.isEmpty() && !PQ1.isEmpty()) {
            if (PQ.peek()[0] > PQ1.peek() || (PQ.peek()[0] == PQ1.peek() && count < 0)) {
                int[] pair = PQ.poll();
                if (op1 > 0) {
                    if (pair[1] == 0 && count++ < 0)
                        res--;
                    res += (pair[0] + 1) / 2;
                    op1--;
                } else {
                    res += pair[0];
                }
            } else {
                int num = PQ1.poll();
                if (op1 > 0) {
                    if (count-- > 0)
                        res--;
                    res += (num + 1) / 2;
                    op1--;
                } else {
                    res += num;
                }
            }
        }
        while (!PQ.isEmpty()) {
            int[] pair = PQ.poll();
            if (op1 > 0) {
                if (pair[1] == 0 && count++ < 0)
                    res--;
                res += (pair[0] + 1) / 2;
                op1--;
            } else {
                res += pair[0];
            }
        }
        while (!PQ1.isEmpty()) {
            int num = PQ1.poll();
            if (op1 > 0) {
                if (count-- > 0)
                    res--;
                res += (num + 1) / 2;
                op1--;
            } else {
                res += num;
            }
        }
        return res;
    }
}
