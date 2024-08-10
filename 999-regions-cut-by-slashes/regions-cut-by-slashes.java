class Solution {
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        int size=n*3;
        int region[][]=new int[size][size];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){ 
                if(grid[i].charAt(j)=='/'){
                    region[i*3][j*3+2]=1;
                    region[i*3+1][j*3+1]=1;
                    region[i*3+2][j*3]=1;
                }
                else if(grid[i].charAt(j)=='\\'){
                    region[i*3][j*3]=1;
                    region[i*3+1][j*3+1]=1;
                    region[i*3+2][j*3+2]=1;

                }
            }
        }
        int regions=0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(region[i][j]==0){
                    regions++;
                    dfs(region,i,j);
                }
            }
            
        }
        return regions;
        
    }
    void dfs(int [][]grid,int i,int j){
        int n=grid.length;
        if(i<0 || i>=n ||j<0 || j>=n || grid[i][j]!=0){
          return;        
        }
          //mark ggrid visited
            grid[i][j]=1;
            dfs(grid,i-1,j);
            dfs(grid,i,j-1);
            dfs(grid,i+1,j);
            dfs(grid,i,j+1);

    }
}