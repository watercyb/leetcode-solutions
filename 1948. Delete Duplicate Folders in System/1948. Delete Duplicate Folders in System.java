/*
 * Problem: 1948. Delete Duplicate Folders in System
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/delete-duplicate-folders-in-system/
 * Language: java
 * Date: 2026-04-22
 */

class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        Node root = new Node();
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            Node node = root;
            for (String str : path) {
                if (!node.next.containsKey(str)) {
                    Node next = new Node();
                    node.next.put(str, next);
                    node.list.add(str);
                    node = next;
                } else {
                    node = node.next.get(str);
                }
            }
            node.idx = i;
        }
        getH(root, true);
        getRes(root, paths);
        return res;
    }

    List<List<String>> res = new ArrayList<>();
    HashMap<String, Node> sames = new HashMap<>();

    public void getRes(Node node, List<List<String>> paths) {
        for (Map.Entry<String, Node> entry : node.next.entrySet()) {
            Node nodeNext = entry.getValue();
            if (!nodeNext.isDup) {
                res.add(paths.get(nodeNext.idx));
                getRes(nodeNext, paths);
            }
        }
    }

    public String getH(Node node, boolean isRoot) {
        StringBuilder SB = new StringBuilder();
        Collections.sort(node.list);
        for (String k : node.list) {
            SB.append('(').append(getH(node.next.get(k), false)).append(')').append(k);
        }
        String h = SB.toString();
        if (!isRoot && !node.next.isEmpty()) {
            if (!sames.containsKey(h)) {
                sames.put(h, node);
            } else {
                sames.get(h).isDup = true;
                node.isDup = true;
            }
        }
        return h;
    }
}

class Node {
    HashMap<String, Node> next = new HashMap<>();
    List<String> list = new ArrayList<>();
    int idx = 0;
    boolean isDup = false;
}
