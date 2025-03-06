class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n=grid.length;
        int[]res=new int[2];
        int size=n*n;
        int dup=-1;
        int sum=0;
        HashSet<Integer>set=new HashSet<>();
         for (int i=0; i < n;i++) {
            for (int j=0; j<n;j++) {
                sum+=grid[i][j];
                if(set.contains(grid[i][j])){
                    dup=grid[i][j];

                }
                else{
                    set.add(grid[i][j]);
                }

            }
         }
         int actSum=size*(size+1)/2;
         res[0]=dup;
         res[1]= actSum-(sum-dup);
         return res;



    }
}