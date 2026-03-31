/*
 * Problem: 282. Expression Add Operators
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/expression-add-operators/
 * Language: java
 * Date: 2026-03-31
 */

class Solution {
    public List<String> addOperators(String num, int target) {
        char[] nums = num.toCharArray();
        dfs(nums, new char[num.length() * 2], 0, 0, 0, 1, target);
        return res;
    }

    List<String> res = new ArrayList<>();

    public void dfs(char[] nums, char[] chrs, int idx, int i, long sum, long a, int target) {
        if (Math.abs(sum - target) > Math.abs(Math.pow(10, nums.length - i) *
                (Math.abs(a) + 1))) {
            return;
        }
        long b = 0;
        while (i < nums.length - 1) {
            b *= 10;
            b += nums[i] - '0';
            chrs[idx++] = nums[i];
            chrs[idx++] = '+';
            dfs(nums, chrs, idx, i + 1, sum + a * b, 1, target);
            idx--;
            chrs[idx++] = '-';
            dfs(nums, chrs, idx, i + 1, sum + a * b, -1, target);
            idx--;
            chrs[idx++] = '*';
            dfs(nums, chrs, idx, i + 1, sum, a * b, target);
            idx--;
            if (b == 0)
                return;
            i++;
        }
        b *= 10;
        b += nums[i] - '0';
        chrs[idx++] = nums[i];
        if (sum + a * b == target)
            res.add(new String(chrs, 0, idx));
    }
}
