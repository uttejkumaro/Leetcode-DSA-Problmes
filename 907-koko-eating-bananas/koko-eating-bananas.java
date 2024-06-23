class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int mink = 1;
         int maxk = 1000000000;
         int result = -1;
         while(mink<=maxk){
            int mid = (mink+maxk)/2;
            int j = 0;
            int time = 0;
            while(j<piles.length){
                time += Math.ceil((double)piles[j]/mid);
                j++;
            }
            if(time<=h){
                result = mid;
                maxk = mid-1;
            }
            else{
                mink = mid+1;
            }
         }
         return result;
    }
}