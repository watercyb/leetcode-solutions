/*
 * Problem: 3433. Count Mentions Per User
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/count-mentions-per-user/
 * Language: java
 * Date: 2026-05-07
 */

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        Collections.sort(events,
                (a, b) -> Integer.parseInt(a.get(1)) == Integer.parseInt(b.get(1)) ? b.get(0).compareTo(a.get(0))
                        : Integer.parseInt(a.get(1)) - Integer.parseInt(b.get(1)));
        int[] times = new int[numberOfUsers];
        int[] res = new int[numberOfUsers];
        for (List<String> event : events) {
            if (event.get(0).equals("MESSAGE")) {
                int time = Integer.parseInt(event.get(1));
                if (event.get(2).equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        res[i]++;
                    }
                } else if (event.get(2).equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (time >= times[i])
                            res[i]++;
                    }
                } else {
                    for (String str : event.get(2).split(" ")) {
                        int num = 0;
                        for (int j = 2; j < str.length(); j++) {
                            num = num * 10 + str.charAt(j) - '0';
                        }
                        res[num]++;
                    }
                }
            } else {
                int time = Integer.parseInt(event.get(1));
                int idx = Integer.parseInt(event.get(2));
                times[idx] = time + 60;
            }
        }
        return res;
    }
}
