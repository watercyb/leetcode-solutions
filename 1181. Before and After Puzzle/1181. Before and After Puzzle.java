/*
 * Problem: 1181. Before and After Puzzle
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/before-and-after-puzzle/
 * Language: java
 * Date: 2026-04-14
 */

class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        HashSet<String> HS = new HashSet<>();
        HashMap<String, List<String>> prefs = new HashMap<>();
        HashMap<String, List<String>> surfs = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
            String[] strs = getArr(phrases[i]);
            for (String str : surfs.getOrDefault(strs[0], new ArrayList<>())) {
                HS.add(connect(str, strs[1]));
            }
            for (String str : prefs.getOrDefault(strs[2], new ArrayList<>())) {
                HS.add(connect(phrases[i], str));
            }
            if (!prefs.containsKey(strs[0])) {
                List<String> list = new ArrayList<>();
                list.add(strs[1]);
                prefs.put(strs[0], list);
            } else {
                prefs.get(strs[0]).add(strs[1]);
            }
            if (!surfs.containsKey(strs[2])) {
                List<String> list = new ArrayList<>();
                list.add(phrases[i]);
                surfs.put(strs[2], list);
            } else {
                surfs.get(strs[2]).add(phrases[i]);
            }
        }
        List<String> res = new ArrayList<>(HS);
        Collections.sort(res);
        return res;
    }

    public String connect(String a, String b) {
        return new StringBuilder(a).append(b).toString();
    }

    public String[] getArr(String phrase) {
        int idx = phrase.indexOf(" ");
        if (idx == -1) {
            return new String[] { phrase, "", phrase };
        } else {
            return new String[] { phrase.substring(0, idx), phrase.substring(idx),
                    phrase.substring(phrase.lastIndexOf(" ") + 1) };
        }
    }
}
