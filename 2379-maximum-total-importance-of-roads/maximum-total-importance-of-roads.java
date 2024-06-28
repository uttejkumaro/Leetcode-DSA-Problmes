class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // Array to store the degree (number of connections) of each city
        int[] degree = new int[n];        
        // Calculate the degree of each city
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }        
        // array of cities and sort them based on their degrees
        Integer[] cities = new Integer[n];
         //here we have used Integer [] (wrapper -stores integer as objects) and (allows null value also)because we are going to use comparror which we cant do in int[]
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }
        Arrays.sort(cities, (a, b) -> degree[b] - degree[a]);  // Sort in descending order of degree
        
        // Assign importance values
        long[] importance = new long[n];
        for (int i = 0; i < n; i++) {
            importance[cities[i]] = n - i;
        }
        
        // Calculate the total importance of all roads
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += importance[road[0]] + importance[road[1]];
        }
        
        return totalImportance;
    }
}
/*If n = 4 and roads = [[0, 1], [1, 2], [2, 3], [3, 0], [0, 2]], and assuming the degree array after calculation is [3, 2, 3, 2], then:

cities after sorting based on degree will be [0, 2, 1, 3].
importance array will be [4, 2, 3, 1] after assigning importance values (n - i where i is the index in the sorted cities array).
*/