/*
 * Problem: 1152. Analyze User Website Visit Pattern
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/analyze-user-website-visit-pattern/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        List<List<Node>> Li = new ArrayList<>();
        HashMap<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            if (!HM.containsKey(username[i])) {
                HM.put(username[i], Li.size());
                List<Node> tmp = new ArrayList<>();
                tmp.add(new Node(timestamp[i], website[i]));
                Li.add(tmp);
            } else {
                Li.get(HM.get(username[i])).add(new Node(timestamp[i], website[i]));
            }
        }
        int n = 0;
        for (List<Node> l : Li) {
            if (l.size() >= 3) {
                n++;
                Collections.sort(l, (a, b) -> a.timestamp - b.timestamp);
            }
        }
        HashSet<String>[] HS = new HashSet[n];
        int idx = 0;
        for (List<Node> l : Li) {
            if (l.size() >= 3) {
                HashSet<String> tmp = new HashSet<>();
                for (int i = 0; i < l.size() - 2; i++) {
                    StringBuilder SB = new StringBuilder(l.get(i).website);
                    SB.append(' ');
                    int a = SB.length();
                    for (int j = i + 1; j < l.size() - 1; j++) {
                        SB.append(l.get(j).website);
                        SB.append(' ');
                        int b = SB.length();
                        for (int k = j + 1; k < l.size(); k++) {
                            tmp.add(SB.append(l.get(k).website).toString());
                            SB.setLength(b);
                        }
                        SB.setLength(a);
                    }
                }
                HS[idx++] = tmp;
            }
        }
        String res = "";
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (String str : HS[i]) {
                int count = 1;
                for (int j = i + 1; j < n; j++) {
                    if (HS[j].contains(str))
                        count++;
                }
                if (count > max || (count == max && str.compareTo(res) < 0)) {
                    max = count;
                    res = str;
                }
            }
        }
        return Arrays.asList(res.split(" "));
    }
}

class Node {
    int timestamp;
    String website;

    public Node(int timestamp, String website) {
        this.timestamp = timestamp;
        this.website = website;
    }
}
