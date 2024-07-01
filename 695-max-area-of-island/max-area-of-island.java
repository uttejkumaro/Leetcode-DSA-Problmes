class Solution {
    int maxArea=0;
    public int maxAreaOfIsland(int[][] grid) {
      
        for( int i=0;i<grid.length;i++){
            for(int  j=0;j<grid[0].length;j++){
                maxArea=Math.max(maxArea,maxAreaIsland(grid,i,j));
            }
        }
        return maxArea;        
    }
    int  maxAreaIsland(int [][]grid,int r,int c){
        if(r<0 || c<0 || r==grid.length || c==grid[0].length || grid[r][c]==0 ){
            return 0;
        }
        grid[r][c]=0;
        return(1+maxAreaIsland(grid,r+1,c)+
                maxAreaIsland(grid,r-1,c)+
                maxAreaIsland(grid,r,c+1)+
                maxAreaIsland(grid,r,c-1) );//1 added to add current  grid
                
    }
    
}