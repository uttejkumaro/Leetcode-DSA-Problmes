class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0,sum=0,rem;
        int mod[]=new int[k];
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            rem=sum%k;
            if(rem<0)
            rem+=k;
            mod[rem]++;
        }
        for(int i=0;i<k;i++)
        {
            if(mod[i]>1)
            count+=(mod[i]*(mod[i]-1))/2;
        }
        count+=mod[0];
        return count;
    }
}