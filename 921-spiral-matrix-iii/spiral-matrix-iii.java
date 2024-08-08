class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result=new  int[rows *cols][2];
        int directions[]={0,1,0,-1,0};
        int step=1;
        int index=0;
        result[index++]=new int[]{rStart,cStart};
      while(index<rows*cols){
        for(int i=0;i<4;i++){ //4 dir
        int dx=directions[i];
        int dy=directions[i+1];
        for(int j=0;j<step;j++){
            rStart+=dx;
            cStart+=dy;
            if(rStart>=0 && rStart<rows && cStart>=0 && cStart<cols){
                result[index++]=new int[]{rStart,cStart};
            }
        }
        if(i==1 || i==3){
            step++;
        }

        }
      }
        return result;
        
    }
}