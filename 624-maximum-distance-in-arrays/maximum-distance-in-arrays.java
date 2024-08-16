class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min=arrays.get(0).get(0);
        int max=arrays.get(0).get(arrays.get(0).size()-1);
        int minIdx=0;
        int maxIdx=0;
        int diff=0;
        for(int i=1;i<arrays.size();i++){
            List<Integer>arr=arrays.get(i);
            int currMin=arr.get(0);
            int currMax=arr.get(arr.size()-1);
            if(i!=minIdx){
                diff=Math.max(diff,Math.abs(currMax-min));
            }
            if(i!=maxIdx){
                diff=Math.max(diff,Math.abs(max-currMin));
            }
            if(currMin<min){
                min=currMin;
                minIdx=i;
            }
            if(currMax>max){
                max=currMax;
                maxIdx=i;
            }
            
        }

        return  diff;

        
    }
}