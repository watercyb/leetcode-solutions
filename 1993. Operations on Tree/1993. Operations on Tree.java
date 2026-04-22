/*
 * Problem: 1993. Operations on Tree
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/operations-on-tree/
 * Language: java
 * Date: 2026-04-22
 */

class LockingTree {
    int[] parent;
    int[][] child;
    int[] locks;

    public LockingTree(int[] parent) {
        this.parent = parent;
        List<Integer>[] lists = new ArrayList[parent.length];
        for (int i = 0; i < parent.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 1; i < parent.length; i++) {
            lists[parent[i]].add(i);
        }
        child = new int[parent.length][];
        for (int i = 0; i < parent.length; i++) {
            child[i] = new int[lists[i].size()];
            for (int j = 0; j < lists[i].size(); j++) {
                child[i][j] = lists[i].get(j);
            }
        }
        locks = new int[parent.length];
    }

    public boolean lock(int num, int user) {
        if (locks[num] == 0) {
            locks[num] = user;
            return true;
        }
        return false;
    }

    public boolean unlock(int num, int user) {
        if (locks[num] == user) {
            locks[num] = 0;
            return true;
        }
        return false;
    }

    public boolean upgrade(int num, int user) {
        if (locks[num] != 0)
            return false;
        int p = parent[num];
        while (p != -1 && locks[p] == 0) {
            p = parent[p];
        }
        if (p != -1)
            return false;
        if (dfs(num)) {
            locks[num] = user;
            return true;
        }
        return false;
    }

    public boolean dfs(int num) {
        boolean res = false;
        if (locks[num] != 0) {
            locks[num] = 0;
            res = true;
        }
        for (int next : child[num]) {
            res |= dfs(next);
        }
        return res;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */
