/*
 * Problem: 3508. Implement Router
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/implement-router/
 * Language: java
 * Date: 2026-05-08
 */

class Router {
    List<List<Node>> lists = new ArrayList<>();
    int[] ls = new int[100000];
    int memoryLimit;
    HashSet<Long> HS = new HashSet<>();
    HashMap<Integer, Integer> HM = new HashMap<>();
    HashMap<Integer, Integer> HM1 = new HashMap<>();
    Node[] nodes = new Node[100000];
    int nodeL = 0;
    int nodeR = 0;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        int idx = 0;
        if (!HM.containsKey(destination)) {
            idx = HM.size();
            HM.put(destination, idx);
            lists.add(new ArrayList<>());
        } else {
            idx = HM.get(destination);
        }
        int t = 0;
        if (!HM1.containsKey(timestamp)) {
            t = HM1.size();
            HM1.put(timestamp, t);
        } else {
            t = HM1.get(timestamp);
        }
        long h = h(source, destination, t);
        if (!HS.add(h))
            return false;
        Node currentNode = new Node(source, idx, destination, timestamp, h);
        if (memoryLimit == 0) {
            Node node = nodes[nodeL++];
            int firstIdx = node.idx;
            ls[firstIdx]++;
            HS.remove(node.h);
            memoryLimit++;
        }
        lists.get(idx).add(currentNode);
        nodes[nodeR++] = currentNode;
        memoryLimit--;
        return true;
    }

    public long h(int source, int destination, int idx) {
        return 20000100000l * source + destination * 100000 + idx;
    }

    public int[] forwardPacket() {
        if (nodeL == nodeR)
            return new int[0];
        Node node = nodes[nodeL++];
        int idx = node.idx;
        ls[idx]++;
        memoryLimit++;
        HS.remove(node.h);
        return new int[] { node.source, node.destination, node.timestamp };
    }

    public int getCount(int destination, int startTime, int endTime) {
        int idx = HM.getOrDefault(destination, -1);
        if (idx == -1)
            return 0;
        List<Node> list = lists.get(idx);
        int left = ls[idx];
        int l = binarySearch(list, left, startTime);
        if (l == list.size())
            return 0;
        int r = binarySearch1(list, left, endTime);
        return r - l;
    }

    public int binarySearch(List<Node> list, int left, int t) {
        int right = list.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (list.get(mid).timestamp >= t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int binarySearch1(List<Node> list, int left, int t) {
        int right = list.size();
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (list.get(mid).timestamp > t) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

class Node {
    int source;
    int idx;
    int destination;
    int timestamp;
    long h;

    public Node(int source, int idx, int destination, int timestamp, long h) {
        this.source = source;
        this.idx = idx;
        this.destination = destination;
        this.timestamp = timestamp;
        this.h = h;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
