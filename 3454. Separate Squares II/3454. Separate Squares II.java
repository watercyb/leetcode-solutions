/*
 * Problem: 3454. Separate Squares II
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/separate-squares-ii/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public double separateSquares(int[][] squares) {
        Edge[] edges = new Edge[squares.length * 2];
        int idx = 0;
        List<Integer> xList = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < squares.length; i++) {
            int x1 = squares[i][0];
            int x2 = squares[i][0] + squares[i][2];
            edges[idx++] = new Edge(x1, x2, squares[i][1], true);
            edges[idx++] = new Edge(x1, x2, squares[i][1] + squares[i][2], false);
            xList.add(x1);
            xList.add(x2);
            max = Math.max(x2, max);
        }
        Arrays.sort(edges, (a, b) -> a.y - b.y);
        int[] xArr = new int[xList.size()];
        for (int i = 0; i < xArr.length; i++) {
            xArr[i] = xList.get(i);
        }
        Arrays.sort(xArr);
        int[] xArrUnq = new int[xArr.length];
        idx = 0;
        for (int i = 0; i < xArr.length; i++) {
            if (i > 0 && xArr[i] == xArr[i - 1])
                continue;
            xArrUnq[idx++] = xArr[i];
        }
        idxToX = Arrays.copyOf(xArrUnq, idx);
        HM = new HashMap<>();
        for (int i = 0; i < idxToX.length; i++) {
            HM.put(idxToX[i], i);
        }
        long prv = -1;
        long prvW = 0;
        Node root = new Node(0, idxToX.length - 1);
        List<TopEdge> list = new ArrayList<>();
        long sum = 0;
        idx = 0;
        while (idx < edges.length) {
            long currentW = 0;
            int y = edges[idx].y;
            if (edges[idx].start) {
                currentW = insert(root, HM.get(edges[idx].x1), HM.get(edges[idx].x2));
            } else {
                currentW = remove(root, HM.get(edges[idx].x1), HM.get(edges[idx].x2));
            }
            idx++;
            while (idx < edges.length && (edges[idx].y == y)) {
                Edge edge = edges[idx];
                if (edge.start) {
                    currentW = insert(root, HM.get(edge.x1), HM.get(edge.x2));
                } else {
                    currentW = remove(root, HM.get(edge.x1), HM.get(edge.x2));
                }
                idx++;
            }
            if (prvW != 0) {
                sum += (y - prv) * prvW;
                list.add(new TopEdge(y, prvW, sum));
            }
            prv = y;
            prvW = currentW;
        }
        for (TopEdge topEdge : list) {
            if (topEdge.sum * 2 >= sum) {
                double diff = (double) (topEdge.sum * 2 - sum) / 2;
                return -diff / topEdge.w + topEdge.y;
            }
        }
        return -1;
    }

    int[] idxToX;
    HashMap<Integer, Integer> HM;

    public int insert(Node node, int l, int r) {
        if (r <= node.l || l >= node.r) {
            return node.range;
        }
        if (l <= node.l && r >= node.r) {
            node.count++;
            node.range = idxToX[node.r] - idxToX[node.l];
            return node.range;
        } else {
            int mid = (node.l + node.r) >>> 1;
            if (node.left == null)
                node.left = new Node(node.l, mid);
            if (node.right == null)
                node.right = new Node(mid, node.r);
            int sum = insert(node.left, l, r) + insert(node.right, l, r);
            if (node.count == 0)
                node.range = sum;
            return node.range;
        }
    }

    public int remove(Node node, int l, int r) {
        if (node == null)
            return 0;
        if (r <= node.l || l >= node.r)
            return node.range;
        if (l <= node.l && r >= node.r) {
            if (node.count-- == 1) {
                node.range = 0;
                if (node.left != null)
                    node.range += node.left.range;
                if (node.right != null)
                    node.range += node.right.range;
            }
            return node.range;
        } else {
            int sum = remove(node.left, l, r) + remove(node.right, l, r);
            if (node.count == 0)
                node.range = sum;
            return node.range;
        }
    }
}

class Edge {
    int x1;
    int x2;
    int y;
    boolean start;

    public Edge(int x1, int x2, int y, boolean start) {
        this.x1 = x1;
        this.x2 = x2;
        this.y = y;
        this.start = start;
    }
}

class TopEdge {
    long y;
    long w;
    long sum;

    public TopEdge(long y, long w, long sum) {
        this.y = y;
        this.w = w;
        this.sum = sum;
    }
}

class Node {
    int l = 0;
    int r = 0;
    int range = 0;
    int count = 0;
    Node left;
    Node right;

    public Node(int l, int r) {
        this.l = l;
        this.r = r;
    }
}
