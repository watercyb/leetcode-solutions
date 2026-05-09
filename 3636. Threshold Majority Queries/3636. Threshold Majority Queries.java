/*
 * Problem: 3636. Threshold Majority Queries
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/threshold-majority-queries/
 * Language: java
 * Date: 2026-05-09
 */

class Solution {
    public int[] subarrayMajority(int[] nums, int[][] queries) {
        Node[] nodes = new Node[queries.length];
        int len = nums.length / (int) Math.sqrt(nums.length);
        for (int i = 0; i < queries.length; i++) {
            nodes[i] = new Node(queries[i], len, i);
        }
        Arrays.sort(nodes);
        int l = -1;
        int r = -1;
        Counter counter = null;
        int[] res = new int[queries.length];
        for (Node node : nodes) {
            if (counter == null || Math.abs(l - node.l) + Math.abs(r - node.r) > node.r - node.l) {
                counter = new Counter(nums.length + 1);
                l = node.l - 1;
                r = node.l;
            }
            HashMap<Integer, Integer> changes = new HashMap<>();
            while (l >= node.l) {
                changes.put(nums[l], changes.getOrDefault(nums[l], 0) + 1);
                l--;
            }
            while (r <= node.r) {
                changes.put(nums[r], changes.getOrDefault(nums[r], 0) + 1);
                r++;
            }
            while (l < node.l - 1) {
                l++;
                changes.put(nums[l], changes.getOrDefault(nums[l], 0) - 1);
            }
            while (r > node.r + 1) {
                r--;
                changes.put(nums[r], changes.getOrDefault(nums[r], 0) - 1);
            }
            for (Map.Entry<Integer, Integer> entry : changes.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                if (v > 0) {
                    counter.insert(k, v);
                } else if (v < 0) {
                    counter.remove(k, v);
                }
            }
            if (node.threshold <= counter.max) {
                res[node.idx] = counter.min;
            } else {
                res[node.idx] = -1;
            }
        }
        return res;
    }
}

class Counter {
    HashSet<Integer>[] counts;
    HashMap<Integer, Integer> HM = new HashMap<>();
    int max = 0;
    int min = 0;

    public Counter(int len) {
        counts = new HashSet[len];
    }

    public void insert(int num, int count) {
        int countOri = HM.getOrDefault(num, 0);
        if (countOri > 0)
            counts[countOri].remove(num);
        countOri += count;
        if (countOri > max) {
            max = countOri;
            min = num;
        } else if (countOri == max) {
            min = Math.min(min, num);
        }
        if (counts[countOri] == null)
            counts[countOri] = new HashSet<>();
        counts[countOri].add(num);
        HM.put(num, countOri);
    }

    public void remove(int num, int count) {
        int countOri = HM.get(num);
        counts[countOri].remove(num);
        if (countOri + count > 0) {
            if (counts[countOri + count] == null)
                counts[countOri + count] = new HashSet<>();
            counts[countOri + count].add(num);
        }
        HM.put(num, countOri + count);
        if (countOri == max) {
            if (counts[countOri].isEmpty()) {
                min = Integer.MAX_VALUE;
                max = 0;
                for (int i = countOri - 1; i >= countOri + count; i--) {
                    if (counts[i] != null && !counts[i].isEmpty()) {
                        for (int id : counts[i]) {
                            min = Math.min(min, id);
                        }
                        max = i;
                        break;
                    }
                }
            } else if (min == num) {
                min = Integer.MAX_VALUE;
                for (int id : counts[countOri]) {
                    min = Math.min(min, id);
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int l;
    int r;
    int reg;
    int threshold;
    int idx;

    public Node(int[] query, int len, int idx) {
        l = query[0];
        r = query[1];
        threshold = query[2];
        reg = l / len;
        this.idx = idx;
    }

    @Override
    public int compareTo(Node node) {
        if (reg != node.reg)
            return reg - node.reg;
        return r - node.r;
    }
}
