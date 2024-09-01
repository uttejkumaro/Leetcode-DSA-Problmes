class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        	int len = original.length;    
    //Edge Case    
    if(m*n!=len){
        return new int[0][0];
    }    
    int[][] result=new int[m][n];    
    int current=0;    
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            result[i][j] = original[current];
            current++;
        }
    }
    return result;
}
        
    }
