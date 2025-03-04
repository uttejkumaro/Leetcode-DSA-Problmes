//k stops -k+1 flights needed
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int cost[]=new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src]=0;
        for(int i=0;i<k+1;i++){
            int tempCost[]=Arrays.copyOf(cost,n);
            for(int flight[]:flights){
                int from=flight[0];
                int to=flight[1];
                int price=flight[2];
                if(cost[from]!=Integer.MAX_VALUE){
                    tempCost[to]=Math.min(cost[from]+price,tempCost[to]);
                }


            }
            cost=tempCost;

        }
        return cost[dst]!=Integer.MAX_VALUE?cost[dst]:-1;
        
    }
}