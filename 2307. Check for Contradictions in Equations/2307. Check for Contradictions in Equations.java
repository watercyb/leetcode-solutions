/*
 * Problem: 2307. Check for Contradictions in Equations
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/check-for-contradictions-in-equations/
 * Language: java
 * Date: 2026-04-26
 */

class Solution {
    public boolean checkContradictions(List<List<String>> equations, double[] values) {
        HashMap<String, Node> HM = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(i);
            Node nodeA = unionFind(HM, equation.get(0));
            Node nodeB = unionFind(HM, equation.get(1));
            if (nodeA.str.equals(nodeB.str)) {
                if (Math.abs(values[i] - nodeA.rate / nodeB.rate) >= 0.00001)
                    return true;
            } else {
                HM.put(nodeA.str, new Node(nodeB.str, values[i] * nodeB.rate / nodeA.rate));
            }
        }
        return false;
    }

    public Node unionFind(HashMap<String, Node> HM, String str) {
        if (!HM.containsKey(str))
            return new Node(str, 1.0);
        Node current = HM.get(str);
        Node head = unionFind(HM, current.str);
        current.str = head.str;
        current.rate = head.rate * current.rate;
        return new Node(current.str, current.rate);
    }
}

class Node {
    String str;
    Double rate;

    public Node(String str, Double rate) {
        this.str = str;
        this.rate = rate;
    }
}
