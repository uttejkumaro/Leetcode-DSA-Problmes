class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles; //the total bottles drunk
        int emptyBottles = numBottles; // the count of empty bottles

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange; // number of new full bottles
            total += newBottles; // Add the new bottles to the total
            emptyBottles = newBottles + (emptyBottles % numExchange); // Update the count of empty bottles
        }

        return total; // Return the total number of bottles drunk
    }
}
