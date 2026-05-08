/*
 * Problem: 3569. Maximize Count of Distinct Primes After Split
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/maximize-count-of-distinct-primes-after-split/
 * Language: java
 * Date: 2026-05-08
 */

class Solution {
    public int[] maximumCount(int[] nums, int[][] queries) {
        if (nonPrime == null)
            getPrime();
        SegmentTree segment = new SegmentTree(nums.length);
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        for (int[] query : queries) {
            max = Math.max(query[1], max);
        }
        int[] index = new int[max + 1];
        Arrays.fill(index, -1);
        int idx = 0;
        List<TreeSet<Integer>> TSList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!nonPrime[nums[i]]) {
                if (index[nums[i]] == -1) {
                    index[nums[i]] = idx++;
                    TreeSet<Integer> TS = new TreeSet<>();
                    TS.add(i);
                    TSList.add(TS);
                } else {
                    TSList.get(index[nums[i]]).add(i);
                }
            }
        }
        for (int i = 0; i < idx; i++) {
            TreeSet<Integer> TS = TSList.get(i);
            if (TS.size() > 1) {
                int l = TS.getFirst();
                int r = TS.getLast();
                segment.insert(l + 1, r, 1);
            }
        }
        int count = idx;
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int id = queries[i][0];
            int val = queries[i][1];
            if (nums[id] != val) {
                if (!nonPrime[nums[id]]) {
                    TreeSet<Integer> TS = TSList.get(index[nums[id]]);
                    if (TS.size() == 1) {
                        TS.remove(id);
                        count--;
                    } else {
                        int l = TS.getFirst();
                        int r = TS.getLast();
                        TS.remove(id);
                        if (l == id || r == id) {
                            segment.insert(l + 1, r, -1);
                            if (TS.size() > 1)
                                segment.insert(TS.getFirst() + 1, TS.getLast(), 1);
                        }
                    }
                }
                if (!nonPrime[val]) {
                    if (index[val] == -1) {
                        index[val] = idx++;
                        TreeSet<Integer> TS = new TreeSet<>();
                        TS.add(id);
                        TSList.add(TS);
                        count++;
                    }
                    TreeSet<Integer> TS = TSList.get(index[val]);
                    if (TS.isEmpty()) {
                        TS.add(id);
                        count++;
                    } else if (TS.size() == 1) {
                        TS.add(id);
                        segment.insert(TS.getFirst() + 1, TS.getLast(), 1);
                    } else {
                        int l = TS.getFirst();
                        int r = TS.getLast();
                        TS.add(id);
                        if (l > id || r < id) {
                            segment.insert(l + 1, r, -1);
                            segment.insert(TS.getFirst() + 1, TS.getLast(), 1);
                        }
                    }
                }
                nums[id] = val;
            }
            res[i] = count + segment.get();
        }
        return res;
    }

    static boolean[] nonPrime;

    public void getPrime() {
        nonPrime = new boolean[100001];
        nonPrime[0] = true;
        nonPrime[1] = true;
        for (int i = 2; i < 100001; i++) {
            if (nonPrime[i])
                continue;
            for (int j = i * i; j >= 0 && j < 100001; j += i) {
                nonPrime[j] = true;
            }
        }
    }
}

class SegmentTree {
    public int[] sums;
    public int[] max;
    public int n;

    public SegmentTree(int size) {
        n = (int) Math.pow(2, Math.floor(Math.log(size) / Math.log(2)) + 1);
        sums = new int[2 * n - 1];
        max = new int[2 * n - 1];
    }

    public void insert(int l, int r, int num) {
        update(l + n - 1, num);
        update(r + n - 1 + 1, -num);
    }

    public int get() {
        return max[0];
    }

    private void update(int i, int num) {
        sums[i] += num;
        max[i] = sums[i];
        while (i > 0) {
            i = (i - 1) / 2;
            sums[i] += num;
            max[i] = Math.max(max[2 * i + 1], sums[2 * i + 1] + max[2 * i + 2]);
        }
    }
}
