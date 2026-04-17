/*
 * Problem: 1487. Making File Names Unique
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/making-file-names-unique/
 * Language: java
 * Date: 2026-04-17
 */

class Solution {
    public String[] getFolderNames(String[] names) {
        HashSet<String> HS = new HashSet<>(names.length, 0.99f);
        HashMap<String, Integer> HM = new HashMap<>(names.length, 0.99f);
        for (int i = 0; i < names.length; i++) {
            if (!HS.add(names[i])) {
                int idx = HM.getOrDefault(names[i], 1);
                while (true) {
                    String str = new StringBuilder(names[i]).append('(').append(idx).append(')').toString();
                    if (HS.add(str)) {
                        HM.put(names[i], idx + 1);
                        names[i] = str;
                        break;
                    }
                    idx++;
                }
            }
        }
        return names;
    }
}
