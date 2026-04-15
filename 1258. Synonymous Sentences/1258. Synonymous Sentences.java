/*
 * Problem: 1258. Synonymous Sentences
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/synonymous-sentences/
 * Language: java
 * Date: 2026-04-15
 */

class Solution {
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        HashMap<String, String> HM = new HashMap<>();
        for (List<String> synonym : synonyms) {
            String a = unionFind(HM, synonym.get(0));
            String b = unionFind(HM, synonym.get(1));
            if (!a.equals(b))
                HM.put(a, b);
        }
        HashMap<String, List<String>> HMList = new HashMap<>();
        for (Map.Entry<String, String> entry : HM.entrySet()) {
            String head = unionFind(HM, entry.getKey());
            if (!HMList.containsKey(head)) {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                HMList.put(head, list);
            } else {
                HMList.get(head).add(entry.getKey());
            }
        }
        for (List<String> list : HMList.values()) {
            Collections.sort(list);
        }
        List<String> res = new ArrayList<>();
        dfs(HM, HMList, text.split(" "), 0, res);
        return res;
    }

    public void dfs(HashMap<String, String> HM, HashMap<String, List<String>> HMList, String[] strs, int i,
            List<String> res) {
        if (i == strs.length) {
            res.add(String.join(" ", strs));
        } else {
            if (!HM.containsKey(strs[i]) || !HMList.containsKey(HM.get(strs[i]))) {
                dfs(HM, HMList, strs, i + 1, res);
            } else {
                for (String str : HMList.get(HM.get(strs[i]))) {
                    strs[i] = str;
                    dfs(HM, HMList, strs, i + 1, res);
                }
            }
        }
    }

    public String unionFind(HashMap<String, String> HM, String str) {
        if (!HM.containsKey(str)) {
            HM.put(str, str);
            return str;
        } else {
            String next = HM.get(str);
            if (!str.equals(next)) {
                next = unionFind(HM, next);
                HM.put(str, next);
            }
            return next;
        }
    }
}
