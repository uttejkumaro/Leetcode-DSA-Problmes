class Solution {
    public int lenLongestFibSubseq(int[] arr) {
      int n = arr.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], i);
        }
        HashMap<Integer,Integer>dp=new HashMap<>();
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int a=arr[j];
                int b=arr[i];
                int c=a+b;
                if(mp.containsKey(c)){
                    int k=mp.get(c);
                    int len=dp.getOrDefault(j*n+i,2)+1;
                    dp.put(i*n+k,len);
                    max=Math.max(max,len);
                }
            }
        }
        return max>=3?max:0;

        
    }
}