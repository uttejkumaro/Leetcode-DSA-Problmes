class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int col=matrix[0].length;
        int max=0;
        for(int [] row:matrix){
            int flip[]=new int[col];
            int count=0;
            for(int c=0;c<col;c++){
                flip[c]=1-row[c];
                //flip[c]=1^row[c];

            }
            for(int []same:matrix){
                if(Arrays.equals(same,flip) || Arrays.equals(same,row)){
                    count++;
                }
            }
            max=Math.max(max,count);

        }
        return max;

        
    }
}