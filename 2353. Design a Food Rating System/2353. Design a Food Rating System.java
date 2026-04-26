/*
 * Problem: 2353. Design a Food Rating System
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/design-a-food-rating-system/
 * Language: java
 * Date: 2026-04-26
 */

class FoodRatings {
    HashMap<String, PriorityQueue<food>> HM = new HashMap<>();
    HashMap<String, food> foods = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            food tmp = new food(foods[i], cuisines[i], ratings[i]);
            this.foods.put(foods[i], tmp);
            if (!HM.containsKey(cuisines[i])) {
                PriorityQueue<food> PQ = new PriorityQueue<>(
                        (a, b) -> a.rating == b.rating ? a.name.compareTo(b.name) : b.rating - a.rating);
                PQ.add(tmp);
                HM.put(cuisines[i], PQ);
            } else {
                PriorityQueue<food> PQ = HM.get(cuisines[i]);
                PQ.add(tmp);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        food tmp = foods.get(food);
        tmp.name = "";
        PriorityQueue<food> PQ = HM.get(tmp.cuisine);
        tmp=new food(food, tmp.cuisine, newRating);
        PQ.add(tmp);
        foods.remove(tmp.name);
        foods.put(tmp.name, tmp);
    }

    public String highestRated(String cuisine) {
        PriorityQueue<food> PQ = HM.get(cuisine);
        while (PQ.peek().name.equals(""))
            PQ.poll();
        return PQ.peek().name;
    }
}

class food {
    String name;
    String cuisine;
    int rating;

    public food(String name, String cuisine, int rating) {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
