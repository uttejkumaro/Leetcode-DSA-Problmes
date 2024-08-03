class Solution {
    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean composite []=new boolean[n];
        for(int i=2;i <Math.sqrt(n);i++){
            if(!composite[i]){
                for(int j=i*i;j<n;j+=i){
                    composite[j]=true;
                }

            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(!composite[i]){
                count++;

            }
        }  
         return count;      
    }
   
}