class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer>res=new ArrayList<>();
        int cand1=0,cand2=0;
        int count1=0,count2=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(cand1==nums[i]) count1++;
            else if(cand2==nums[i]) count2++;
            else if(count1==0){
                cand1=nums[i];
                count1++;
            }
            else if(count2==0){
                cand2=nums[i];
                count2++;
            }
           else{count1--;
           count2--;}
        }        
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(cand1==nums[i]){
                count1++;
            }
            else if(cand2==nums[i]){
                count2++;
            }
            
        }
        if(count1>n/3) res.add(cand1);
        if(count2>n/3) res.add(cand2);
        return res;
    }
}