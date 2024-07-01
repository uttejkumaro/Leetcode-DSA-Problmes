/* class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3 )return false;
          for(int i=0;i<arr.length-2;i++){
            if(arr[i]%2==1 && arr[i+1]%2==1 && arr[i+2]%2==1){
                return true;
            }
        }
        return false;
             
    }
}
*/
//sliding window concept
class Solution{
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=0;
        for (int i:arr){
            if(i%2==1){
                count++;
            
            if(count==3){
                return true;
                }
            }
            else{
                count=0;
            }
        }
        return false;
    }

} 