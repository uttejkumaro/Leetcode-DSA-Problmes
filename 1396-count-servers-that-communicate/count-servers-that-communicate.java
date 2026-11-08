class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int rowsCount[]=new int[n];
        int colsCount[]=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    rowsCount[i]++;
                    colsCount[j]++;
                }
            }
        }
        int servers=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1&&(rowsCount[i]>1 || colsCount[j]>1)){
                   servers++;
                }
            }
        }
        return servers;
    }
}