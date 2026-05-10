/*
 * Problem: 3771. Total Score of Dungeon Runs
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/total-score-of-dungeon-runs/
 * Language: java
 * Date: 2026-05-10
 */

class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int[] arr = new int[damage.length + 1];
        arr[0] = 0;
        int idx = 1;
        long res = 0;
        for (int i = 0; i < damage.length; i++) {
            arr[idx] = arr[idx - 1] - damage[i];
            res += binarySearch(arr, idx, hp + arr[idx] - requirement[i]);
            idx++;
        }
        return res;
    }

    public int binarySearch(int[] arr, int idx, int target) {
        int l = 0;
        int r = idx;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] <= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return idx - l;
    }
}
