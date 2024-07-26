class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int graph[][]=new int[n][n]; 
        for(int row[]:graph){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        //self elements
        for(int i=0;i<n;i++){
            graph[i][i]=0;
            
        }
        for(int edge[]:edges){
            int  u =edge[0];
            int  v =edge[1];
            int  w =edge[2];
            graph[u][v]=w;
            graph[v][u]=w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        // Step 3: Count reachable cities for each city
        int[] reachableCities = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) {
                    reachableCities[i]++;
                }
            }
        }

        // Step 4: Find the city with the smallest number of reachable cities
        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (reachableCities[i] < minCount || (reachableCities[i] == minCount && i > minCity)) {
                minCity = i;
                minCount = reachableCities[i];
            }
        }

        // Step 5: Return the result
        return minCity;
    }
}
        
        