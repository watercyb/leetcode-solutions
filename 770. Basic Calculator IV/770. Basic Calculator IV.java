/*
 * Problem: 770. Basic Calculator IV
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/basic-calculator-iv/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        List<Node> list = dfs(expression.toCharArray());
        HashMap<String, Integer> evals = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            evals.put(evalvars[i], evalints[i]);
        }
        HashMap<String, int[]> HM = new HashMap<>();
        int sum = 0;
        for (Node node : list) {
            Collections.sort(node.list);
            int num = node.num;
            StringBuilder SB = new StringBuilder();
            int count = 0;
            for (String str : node.list) {
                if (evals.containsKey(str)) {
                    num *= evals.get(str);
                } else {
                    SB.append(str).append('*');
                    count++;
                }
            }
            if (num == 0)
                continue;
            if (count > 0) {
                SB.setLength(SB.length() - 1);
                String str = SB.toString();
                if (HM.containsKey(str)) {
                    int[] v = HM.get(str);
                    v[0] += num;
                    if (v[0] == 0)
                        HM.remove(str);
                } else {
                    int[] v = { num, count };
                    HM.put(str, v);
                }
            } else {
                sum += num;
            }
        }
        NodeSort[] nodes = new NodeSort[HM.size()];
        int idx = 0;
        for (Map.Entry<String, int[]> entry : HM.entrySet()) {
            String k = entry.getKey();
            int[] v = entry.getValue();
            nodes[idx++] = new NodeSort(k, v);
        }
        Arrays.sort(nodes, (a, b) -> a.count == b.count ? a.str.compareTo(b.str) : b.count - a.count);
        List<String> res = new ArrayList<>();
        for (NodeSort node : nodes) {
            StringBuilder SB = new StringBuilder();
            SB.append(node.num);
            if (node.count > 0)
                SB.append('*').append(node.str);
            res.add(SB.toString());
        }
        if (sum != 0)
            res.add(String.valueOf(sum));
        return res;
    }

    int idx = 0;

    public List<Node> dfs(char[] chrs) {
        List<Node> res = new ArrayList<>();
        List<Node> current = new ArrayList<>();
        int sign = 1;
        boolean isMultiple = false;
        while (idx < chrs.length) {
            if (chrs[idx] == '(') {
                idx++;
                List<Node> list = dfs(chrs);
                if (isMultiple) {
                    isMultiple = false;
                    current = multiple(current, list);
                } else {
                    current = list;
                }
            } else if (chrs[idx] == '+') {
                if (sign != 0) {
                    merge(res, current, sign);
                }
                current = new ArrayList<>();
                sign = 1;
                idx++;
            } else if (chrs[idx] == '-') {
                if (sign != 0) {
                    merge(res, current, sign);
                }
                current = new ArrayList<>();
                sign = -1;
                idx++;
            } else if (chrs[idx] == '*') {
                isMultiple = true;
                idx++;
            } else if (Character.isDigit(chrs[idx])) {
                int num = chrs[idx] - '0';
                idx++;
                while (idx < chrs.length && Character.isDigit(chrs[idx])) {
                    num = num * 10 + chrs[idx] - '0';
                    idx++;
                }
                if (isMultiple) {
                    isMultiple = false;
                    multiple(current, num);
                } else {
                    if (num != 0)
                        current.add(new Node(num));
                }
            } else if (Character.isLowerCase(chrs[idx])) {
                StringBuilder SB = new StringBuilder();
                SB.append(chrs[idx]);
                idx++;
                while (idx < chrs.length && Character.isLowerCase(chrs[idx])) {
                    SB.append(chrs[idx]);
                    idx++;
                }
                if (isMultiple) {
                    isMultiple = false;
                    multiple(current, SB.toString());
                } else {
                    current.add(new Node(SB.toString()));
                }
            } else if (chrs[idx] == ')') {
                if (sign != 0)
                    merge(res, current, sign);
                idx++;
                return res;
            } else {
                idx++;
            }
        }
        if (sign != 0)
            merge(res, current, sign);
        return res;
    }

    public void merge(List<Node> a, List<Node> b, int p) {
        for (Node node : b) {
            node.num *= p;
            a.add(node);
        }
    }

    public void multiple(List<Node> a, int b) {
        if (b == 0) {
            a.clear();
        } else {
            for (Node node : a) {
                node.num *= b;
            }
        }
    }

    public void multiple(List<Node> a, String b) {
        for (Node node : a) {
            node.list.add(b);
        }
    }

    public void multiple(List<Node> a, Node b) {
        if (b.num == 0) {
            a.clear();
        } else {
            for (Node node : a) {
                node.num *= b.num;
                for (String str : b.list) {
                    node.list.add(str);
                }
            }
        }
    }

    public List<Node> multiple(List<Node> a, List<Node> b) {
        List<Node> res = new ArrayList<>();
        for (Node nodeA : a) {
            for (Node nodeB : b) {
                res.add(new Node(nodeA, nodeB));
            }
        }
        return res;
    }
}

class Node {
    List<String> list = new ArrayList<>();
    int num = 1;

    public Node() {

    }

    public Node(int num) {
        this.num = num;
    }

    public Node(String str) {
        list.add(str);
    }

    public Node(Node a, Node b) {
        num = a.num * b.num;
        for (String str : a.list) {
            list.add(str);
        }
        for (String str : b.list) {
            list.add(str);
        }
    }
}

class NodeSort {
    String str;
    int count = 0;
    int num;

    public NodeSort(String str, int[] v) {
        this.str = str;
        count = v[1];
        num = v[0];
    }
}
