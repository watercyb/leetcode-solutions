/*
 * Problem: 49. Group Anagrams
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/group-anagrams/
 * Language: java
 * Date: 2026-03-25
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,Integer> HM = new  HashMap<>();
        int idx=0;
        for (String str: strs) {
            char[] chr = str.toCharArray();
            Arrays.sort(chr);
            String str1 = String.valueOf(chr);
            if (!HM.containsKey(str1)) {
                List<String> LiTmp=new ArrayList<>();
                LiTmp.add(str);
                res.add(LiTmp);
                HM.put(str1,idx);
                idx++;
            } else {
                int thisIdx = HM.get(str1);
                List<String> LiTmp=res.get(thisIdx);
                LiTmp.add(str);
            }
        }
        return res;       
    }
    
}
