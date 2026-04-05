/*
 * Problem: 609. Find Duplicate File in System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-duplicate-file-in-system/
 * Language: java
 * Date: 2026-04-05
 */

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> HM = new HashMap<>();
        for (String path : paths) {
            StringBuilder SB = new StringBuilder();
            String pathName = null;
            String fileName = null;
            char[] chrs = path.toCharArray();
            int idx = 0;
            while (idx < chrs.length) {
                if (chrs[idx] == '(') {
                    fileName = SB.toString();
                    SB.setLength(0);
                    idx++;
                    while (chrs[idx] != ')') {
                        SB.append(chrs[idx]);
                        idx++;
                    }
                    String h = SB.toString();
                    if (!HM.containsKey(h)) {
                        List<String> list = new ArrayList<>();
                        list.add(new StringBuilder(pathName).append(fileName).toString());
                        HM.put(h, list);
                    } else {
                        HM.get(h).add(new StringBuilder(pathName).append(fileName).toString());
                    }
                    idx++;
                } else if (chrs[idx] == ' ') {
                    if (pathName == null)
                        pathName = SB.append('/').toString();

                    SB.setLength(0);
                    idx++;
                } else {
                    SB.append(chrs[idx]);
                    idx++;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : HM.values()) {
            if (list.size() > 1)
                res.add(list);
        }
        return res;
    }

    public String chk(String str) {

        return null;
    }
}
