class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int freshOranges=0;
        Queue<int []>q=new LinkedList<>();
        int mins=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshOranges+=1;
                }

            }
        }
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty() && freshOranges>0){
            int size=q.size();
            for(int i=0;i<size;i++){
            int []curr=q.poll();
            int x,y;
            x=curr[0];
            y=curr[1];
            for(int []dir:dirs){
                int x1=x+dir[0];
                int y1=y+dir[1];
                if(x1>=0 && x1<n && y1>=0 && y1<m && grid[x1][y1]==1){
                    grid[x1][y1]=2;
                    q.add(new int []{x1,y1});
                    freshOranges-=1;
                }
            }
            }
            mins+=1;//mins will incre after expore in 4 dirs;

        }
        return freshOranges==0?mins:-1;
        
    }
}