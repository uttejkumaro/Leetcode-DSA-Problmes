//bfs -using minute counter to count no of step
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0){
            return  -1;
        }
        int m=grid.length;
        int n=grid[0].length;
        Queue<int []>q=new LinkedList<>();
        int fO=0;//freshoranges
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    //add index to queue
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fO+=1;
                }
            }

        }
        int dirs[][]={{0,1},{1,0},{0,-1},{-1,0}};
        int mins=0;
        //bfs
        while(!q.isEmpty() &&  fO>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curr[]=q.poll();
                int x=curr[0];
                int y=curr[1];
                for(int dir[]:dirs ){
                    int x1=x+dir[0];
                    int y1=y+dir[1];
                
                if(x1 >=0 && x1 < m && y1 >=0 && y1<n && grid[x1][y1]==1){
                    grid[x1][y1]=2; //replace rot from fresh
                    q.offer(new int []{x1,y1});
                    fO-=1;
                }
                }

            }
            mins+=1;
        }
        return fO==0?mins:-1;
    }
}