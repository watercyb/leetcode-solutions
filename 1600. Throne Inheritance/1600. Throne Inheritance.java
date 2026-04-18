/*
 * Problem: 1600. Throne Inheritance
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/throne-inheritance/
 * Language: java
 * Date: 2026-04-18
 */

class ThroneInheritance {
    Node king;
    HashMap<String, Node> HM = new HashMap<>();

    public ThroneInheritance(String kingName) {
        king = new Node(kingName);
        HM.put(kingName, king);
    }

    public void birth(String parentName, String childName) {
        Node node = new Node(childName);
        HM.get(parentName).children.add(node);
        HM.put(childName, node);
    }

    public void death(String name) {
        HM.get(name).death = true;
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(king, res);
        return res;
    }

    public void dfs(Node node, List<String> res) {
        if (!node.death)
            res.add(node.name);
        for (Node child : node.children) {
            dfs(child, res);
        }
    }
}

class Node {
    String name;
    boolean death = false;
    List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
