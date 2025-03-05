class Solution {
    private long[] helper(int currentCIty,int parentCity,List<List<Integer>>cities,int seats){
        long persons=currentCIty==0?0:1;
        long fuel=0;

        for(int neigh:cities.get(currentCIty)){
            if(neigh!=parentCity){
                long[] subRes=helper(neigh,currentCIty,cities,seats);
                persons+=subRes[0];
                fuel+=subRes[1];

            }

        }
        long cars=(persons/seats)+(persons%seats!=0?1:0);
        if(currentCIty!=0){
            fuel+=cars;
            }
            long res[]=new long[2];

            res[0]=persons;
            res[1]=fuel;
            return res;

    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int n=roads.length+1;
        List<List<Integer>>cities=new ArrayList<>();
        for(int i=0;i<n;i++){
            cities.add(new ArrayList<>());
        }
        for(int road[]:roads){
            cities.get(road[1]).add(road[0]);
            cities.get(road[0]).add(road[1]);
        }
        return helper(0,-1,cities,seats)[1];

        
    }
}