/*
 * Problem: 2115. Find All Possible Recipes from Given Supplies
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/
 * Language: java
 * Date: 2026-04-24
 */

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> HS = new HashSet<>();
        for (String supply : supplies) {
            HS.add(supply);
        }
        HashMap<String, Integer> HM = new HashMap<>();
        for (int i = 0; i < recipes.length; i++) {
            HM.put(recipes[i], i);
        }
        List<List<Integer>> Li = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            Li.add(new ArrayList<>());
        }
        boolean[] seen = new boolean[recipes.length];
        int[] counts = new int[recipes.length];
        List<String> res = new ArrayList<>();
        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!HS.contains(ingredient)) {
                    counts[i]++;
                    if (HM.containsKey(ingredient)) {
                        Li.get(HM.get(ingredient)).add(i);
                    } else {
                        counts[i] += 1000;
                    }
                }
            }
        }
        for (boolean changed = true; changed;) {
            changed = false;
            for (int i = 0; i < recipes.length; i++) {
                if (!seen[i] && counts[i] == 0) {
                    changed = true;
                    seen[i] = true;
                    for (int in : Li.get(i)) {
                        counts[in]--;
                    }
                    res.add(recipes[i]);
                }
            }
            for (int i = recipes.length - 1; i >= 0; i--) {
                if (!seen[i] && counts[i] == 0) {
                    changed = true;
                    seen[i] = true;
                    for (int in : Li.get(i)) {
                        counts[in]--;
                    }
                    res.add(recipes[i]);
                }
            }
        }
        return res;
    }
}
