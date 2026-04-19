/*
 * Problem: 1604. Alert Using Same Key-Card Three or More Times in a One Hour Period
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
 * Language: java
 * Date: 2026-04-19
 */

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String>[] lists = new ArrayList[24 * 60];
        for (int i = 0; i < keyName.length; i++) {
            int time = (keyTime[i].charAt(0) - '0') * 600 + (keyTime[i].charAt(1) - '0') * 60
                    + (keyTime[i].charAt(3) - '0') * 10
                    + keyTime[i].charAt(4) - '0';
            if (lists[time] == null)
                lists[time] = new ArrayList<>();
            lists[time].add(keyName[i]);
        }
        int j = 0;
        HashMap<String, Integer> HM = new HashMap<>();
        HashSet<String> HS = new HashSet<>();
        for (int i = 0; i <= 60; i++) {
            if (lists[i] != null) {
                for (String name : lists[i]) {
                    int count = HM.getOrDefault(name, 0) + 1;
                    if (count == 3)
                        HS.add(name);
                    HM.put(name, count);
                }
            }
        }
        for (int i = 61; i < lists.length; i++) {
            if (lists[i - 61] != null) {
                for (String name : lists[i - 61]) {
                    HM.put(name, HM.get(name) - 1);
                }
            }
            if (lists[i] != null) {
                for (String name : lists[i]) {
                    int count = HM.getOrDefault(name, 0) + 1;
                    if (count == 3)
                        HS.add(name);
                    HM.put(name, count);
                }
            }
        }
        String[] res = new String[HS.size()];
        int idx = 0;
        for (String str : HS) {
            res[idx++] = str;
        }
        Arrays.sort(res);
        return Arrays.asList(res);
    }
}

class Node {
    String name;
    int time;

    public Node(String name, String time) {
        this.name = name;
        this.time = (time.charAt(0) - '0') * 600 + (time.charAt(1) - '0') * 60 + (time.charAt(3) - '0') * 10
                + time.charAt(4) - '0';
    }
}
