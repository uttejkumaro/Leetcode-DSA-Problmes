class Solution {
    int sum(int n){
       int temp=n,sum=0;
       while(temp>0){
        sum+=temp%10;
        temp/=10;
       }
       return sum;
    }
    // public int maximumSum(int[] nums) {
    //     int n=nums.length;
    //     int max=-1;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             if(i!=j && sum(nums[i])==sum(nums[j])){
    //                 max=Math.max(max,nums[i]+nums[j]);
    //             }
    //         }
    //     }
    //     return max==-1?-1:max;
        
    // }
     public int maximumSum(int[] nums) {
        int n=nums.length;
        int max=-1;
       HashMap<Integer,Integer>mp=new HashMap<>();
       for(int i=0;i<n;i++){
        int s=sum(nums[i]);
        if(mp.containsKey(s)){
            max=Math.max(max,nums[i]+mp.get(s));
            mp.put(s,Math.max(nums[i],mp.get(s)));//if same num sum upadte with which is more val 
        }
        else{
            mp.put(sum(nums[i]),nums[i]);
        }
       }
      
        return max==-1?-1:max;
        
    }
}