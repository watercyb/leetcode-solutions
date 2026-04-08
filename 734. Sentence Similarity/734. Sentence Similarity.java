/*
 * Problem: 734. Sentence Similarity
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/sentence-similarity/
 * Language: java
 * Date: 2026-04-08
 */

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;
        HashMap<String, HashSet<String>> HM = new HashMap<>();
        for (List<String> li : similarPairs) {
            String a = li.get(0);
            String b = li.get(1);
            if (!HM.containsKey(a)) {
                HashSet<String> tmp = new HashSet<>();
                tmp.add(b);
                HM.put(a, tmp);
            } else {
                HM.get(a).add(b);
            }
            if (!HM.containsKey(b)) {
                HashSet<String> tmp = new HashSet<>();
                tmp.add(a);
                HM.put(b, tmp);
            } else {
                HM.get(b).add(a);
            }
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i])
                    && (!HM.containsKey(sentence1[i]) || !HM.get(sentence1[i]).contains(sentence2[i])))
                return false;
        }
        return true;
    }
}
