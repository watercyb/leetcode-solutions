/*
 * Problem: 1916. Count Ways to Build Rooms in an Ant Colony
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/count-ways-to-build-rooms-in-an-ant-colony/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    int mod = 1_000_000_007;

    public int waysToBuildRooms(int[] prevRoom) {
        List<Integer>[] links = new ArrayList[prevRoom.length];
        for (int i = 0; i < prevRoom.length; i++) {
            links[i] = new ArrayList<>();
        }
        for (int i = 1; i < prevRoom.length; i++) {
            links[prevRoom[i]].add(i);
        }
        int[] counts = new int[prevRoom.length];
        dfs(links, counts, 0);
        return (int) (a * reverce(b) % mod);
    }

    long a = 1;
    long b = 1;
    int n = 1;

    public int dfs(List<Integer>[] links, int[] counts, int i) {
        int count = 1;
        for (int next : links[i]) {
            count += dfs(links, counts, next);
        }
        a = a * n % mod;
        b = b * count % mod;
        n++;
        return count;
    }

    public long reverce(long a) {
        if (a == 1)
            return 1;
        return mod - mod / a * reverce(mod % a) % mod;
    }
}
