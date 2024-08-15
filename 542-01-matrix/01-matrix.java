//bfs
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int [][]res=new int[n][m];
        Queue<int []>Q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    res[i][j]=0;
                    Q.offer(new int[]{i,j});
                }
                else{
                    res[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        //bfs
        while(!Q.isEmpty()){
            int cell[]=Q.poll();
            int x=cell[0];
            int y=cell[1];             
            for(int d[]:dir){
                int newX=x+d[0];
                int newY=y+d[1];
                if(newX>=0 && newX<n && newY>=0 && newY<m){
                    if(res[newX][newY]>res[x][y]+1){
                        res[newX][newY]=res[x][y]+1;
                          Q.offer(new int[]{newX,newY});
                        

                    }
                  
                }
            }
        }
        return res;
        
    }
}