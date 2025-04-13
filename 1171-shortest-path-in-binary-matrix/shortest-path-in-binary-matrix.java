class Solution {  

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
         if(grid[0][0]==1||grid[n -1][n -1]==1 ) return -1;
        Queue<int[]>q=new LinkedList<>();
        boolean visited[][]=new boolean[n][n];
        visited[0][0]=true;
        q.add(new int []{0,0,1});
        int dir[][]={{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,1},{1,-1},{-1,-1}};
        while(!q.isEmpty()){
            int [] curr=q.poll();
            int x=curr[0];
            int y=curr[1];
            int len=curr[2];
            if(x==n-1 && y==m-1 ) return len;
            for(int []dirs:dir){
                int x1=x+dirs[0];
                int y1=y+dirs[1];
                while(x1>=0 && y1>=0 && x1<n && y1<n && !visited[x1][y1] && grid[x1][y1]==0 ){
                    q.add(new int[]{x1,y1,len+1});
                    visited[x1][y1]=true;
                }
            }

        }
        return -1;

    
    }
}