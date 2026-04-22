/*
 * Problem: 1912. Design Movie Rental System
 * Difficulty: Hard
 * Link: https://leetcode.com/problems/design-movie-rental-system/
 * Language: java
 * Date: 2026-04-22
 */

class MovieRentingSystem {
    TreeSet<Long>[] movies = new TreeSet[10001];
    TreeSet<Long> rented = new TreeSet<>();
    HashMap<Long, Integer> HM;
    int n;

    public MovieRentingSystem(int n, int[][] entries) {
        this.n = n;
        HM = new HashMap<>(entries.length, 0.99f);
        for (int[] entry : entries) {
            int shopId = entry[0];
            int movieId = entry[1];
            int price = entry[2];
            if (movies[movieId] == null)
                movies[movieId] = new TreeSet<>();
            movies[movieId].add((long) price * n + shopId);
            HM.put((long) movieId * n + shopId, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        TreeSet<Long> TS = movies[movie];
        if (TS == null || TS.isEmpty())
            return res;
        Long h = TS.getFirst();
        for (int i = 0; i < 5 && h != null; i++) {
            res.add((int) (h % n));
            h = TS.higher(h);
        }
        return res;
    }

    public void rent(int shop, int movie) {
        long h = (long) HM.get((long) movie * n + shop) * n + shop;
        movies[movie].remove(h);
        rented.add(h * 10001 + movie);
    }

    public void drop(int shop, int movie) {
        long h = (long) HM.get((long) movie * n + shop) * n + shop;
        rented.remove(h * 10001 + movie);
        movies[movie].add(h);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        if (rented.isEmpty())
            return res;
        Long h = rented.first();
        for (int i = 0; i < 5 && h != null; i++) {
            int shop = (int) (h / 10001 % n);
            int movie = (int) (h % 10001);
            res.add(List.of(shop, movie));
            h = rented.higher(h);
        }
        return res;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */
