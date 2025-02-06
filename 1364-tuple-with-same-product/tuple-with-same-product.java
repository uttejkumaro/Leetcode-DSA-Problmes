class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer>mp=new HashMap<>();
        int res=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int prd=nums[i]*nums[j];
                if(mp.containsKey(prd)){
                    res+=mp.get(prd)*8;
                    mp.put(prd,mp.getOrDefault(prd,0)+1);
                }
                else{
                    mp.put(prd,1);
                }
            }

        }
        return res;
    }
}