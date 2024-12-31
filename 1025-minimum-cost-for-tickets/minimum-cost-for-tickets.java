class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();

    int solve(int[] days, int[] costs, int pos) {
        if (pos >= days.length) return 0; // Base case: No more days to process.

        if (memo.containsKey(pos)) return memo.get(pos); // Check memoization.

        // Option 1: Buy a 1-day pass.
        int nextPos1 = pos + 1; // Next day to process.
        int cost1 = costs[0] + solve(days, costs, nextPos1);

        // Option 2: Buy a 7-day pass.
        int nextPos7 = pos;
        while (nextPos7 < days.length && days[nextPos7] < days[pos] + 7) nextPos7++;
        int cost7 = costs[1] + solve(days, costs, nextPos7);

        // Option 3: Buy a 30-day pass.
        int nextPos30 = pos;
        while (nextPos30 < days.length && days[nextPos30] < days[pos] + 30) nextPos30++;
        int cost30 = costs[2] + solve(days, costs, nextPos30);

        // Find the minimum cost.
        int result = Math.min(cost1, Math.min(cost7, cost30));
        memo.put(pos, result); // Memoize the result for the current position.
        return result;
    }

    public int mincostTickets(int[] days, int[] costs) {
        return solve(days, costs, 0); // Start processing from the first day.
    }
}
