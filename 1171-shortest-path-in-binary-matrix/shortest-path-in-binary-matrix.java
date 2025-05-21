class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0) return -1;
        Queue<int []>q=new LinkedList<>();
        int dirs[][]={{0,1},{0,-1},{-1,-1},{-1,0},{1,1},{-1,1},{1,-1},{1,0}};
        q.add(new int[]{0,0});
        int count=1;
        grid[0][0]=1;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int x=curr[0];
            int y=curr[1];
            int dist=grid[x][y];
            if (x == n - 1 && y == n - 1) return dist;
           
            for(int dir[]:dirs){
                int newX=curr[0]+dir[0];
                int newY=curr[1]+dir[1];
                if( newX<n && newY<n && newX>=0 && newY>=0 && grid[newX][newY]==0 ){
                    q.add(new int[]{newX,newY});
                    grid[newX][newY]=dist+1;
                }
            }
        }
        return -1;

   }
}