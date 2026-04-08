/*
 * Problem: 710. Random Pick with Blacklist
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/random-pick-with-blacklist/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    HashSet<Integer> HS = new HashSet<>();
    Random rand = new Random();
    int n = 0;
    int[] arr;

    public Solution(int n, int[] blacklist) {
        for (int num : blacklist) {
            HS.add(num);
        }
        if (blacklist.length >= n / 5) {
            arr = new int[n - blacklist.length];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (!HS.contains(i))
                    arr[idx++] = i;
            }
        }
        this.n = n;
    }

    public int pick() {
        if (arr == null) {
            int res = rand.nextInt(n);
            while (HS.contains(res)) {
                res = rand.nextInt(n);
            }
            return res;
        } else {
            return arr[rand.nextInt(arr.length)];
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
