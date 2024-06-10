class Solution {
    public int heightChecker(int[] heights) {
       int []sortedheights=heights.clone();
       Arrays.sort(sortedheights);
       int  count=0;
        for (int i=0;i<heights.length;i++){
            if(heights[i]!=sortedheights[i]){
                count++;
            }
        }
        return count;
    }
}