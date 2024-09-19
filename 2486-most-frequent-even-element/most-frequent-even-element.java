class Solution {
    public int mostFrequentEven(int[] nums) {
       HashMap<Integer,Integer>mp=new HashMap<>();
       int ele=-1;
       int maxFreq=0;
       for(int i:nums){
        mp.put(i,mp.getOrDefault(i,0)+1);
       }
       for(int i:mp.keySet()){
        if(i%2==0){
           int  freq=mp.get(i);
           //upadte if curr freq is greater than maxfreq  or equal freq update small num;
            if(freq>maxFreq || (freq==maxFreq && i<ele)){
                ele=i;
                maxFreq=freq;
            }
        }
        
       }
       return ele;
        
    }
}