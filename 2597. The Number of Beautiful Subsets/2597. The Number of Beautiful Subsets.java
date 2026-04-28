/*
 * Problem: 2597. The Number of Beautiful Subsets
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/the-number-of-beautiful-subsets/
 * Language: java
 * Date: 2026-04-28
 */

class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        boolean[] visited = new boolean[1001];
        boolean[] set = new boolean[1001];
        for (int i : nums) {
            set[i] = true;
        }
        int oneSizeGroupCount = 0;
        List<Integer> groups = new ArrayList<>();
        for (int i : nums) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            int count = 1;
            int x = i + k;
            while (x <= 1000 && set[x]) {
                visited[x] = true;
                ++count;
                x += k;
            }
            x = i - k;
            while (x >= 0 && set[x]) {
                visited[x] = true;
                ++count;
                x -= k;
            }
            if (count == 1) {
                ++oneSizeGroupCount;
            } else {
                groups.add(count);
            }
        }
        long ans = (1L << oneSizeGroupCount);
        for (int i : groups) {
            ans *= fib(i);
        }
        System.out.println(ans);
        return (int) ans-1;
    }

    long fib(int size) {
        long x = 1L;
        long y = 2L;
        while (size-- > 1) {
            long tmp = y;
            y = x + y;
            x = tmp;
        }
        return y;
    }
}
