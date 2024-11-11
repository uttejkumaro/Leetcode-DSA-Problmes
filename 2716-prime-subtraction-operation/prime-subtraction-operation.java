class Solution {
    public boolean primeSubOperation(int[] nums) {
        int max= findmax(nums);
        boolean prime[]=prime(max);
        int x=1;
        for(int num:nums){
            int diff=num-x;
            if(diff<0)return false;
            while(diff>0 && !prime[diff]){
                x++;
                diff=num-x;
            }
            if(diff<0)return false;
            x++;
            }
        return true;      

    }
    public boolean[] prime(int n){
        boolean prime[]=new boolean[n];
        Arrays.fill(prime,true);
         if(prime.length>1){
             prime[0] = prime[1] = false;
         }
        for(int i=2;i<n;i++){
            for(int j=i*i;j<n;j+=i){
                prime[j]=false;
            }
        }
        return prime;      
    }
    int max=0;
    private int findmax(int nums[]){
        for(int i:nums){
            max=Math.max(max,i);

        }
        return max;
    }
}