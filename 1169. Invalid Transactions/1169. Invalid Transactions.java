/*
 * Problem: 1169. Invalid Transactions
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/invalid-transactions/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        Node[] nodes = new Node[transactions.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(transactions[i]);
        }
        boolean[] isInvalid = new boolean[transactions.length];
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].amount > 1000) {
                isInvalid[i] = true;
            } else {
                for (int j = 0; j < nodes.length; j++) {
                    if (nodes[j].name.equals(nodes[i].name) && Math.abs(nodes[j].time - nodes[i].time) <= 60
                            && !nodes[j].location.equals(nodes[i].location)) {
                        isInvalid[i] = true;
                        break;
                    }
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < isInvalid.length; i++) {
            if (isInvalid[i])
                res.add(transactions[i]);
        }
        return res;
    }
}

class Node {
    String name;
    String location;
    int time;
    int amount;

    public Node(String transaction) {
        String[] strs = transaction.split(",");
        name = strs[0];
        location = strs[3];
        time = Integer.parseInt(strs[1]);
        amount = Integer.parseInt(strs[2]);
    }
}
