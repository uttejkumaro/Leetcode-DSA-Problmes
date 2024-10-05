class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        if(n>m) return false;
        HashMap<Character,Integer>mp1=new HashMap<>();
        HashMap<Character,Integer>mp2=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp1.put(s1.charAt(i),mp1.getOrDefault(s1.charAt(i),0)+1);
            mp2.put(s2.charAt(i),mp2.getOrDefault(s2.charAt(i),0)+1);
        }
        
       for(int i=n;i<m;i++){
        if(mp1.equals(mp2)) return true;
        char rem=s2.charAt(i-n);
        if(mp2.get(rem)==1){
            mp2.remove(rem);
        }
        else{
            mp2.put(rem,mp2.get(rem)-1);
        }   
        char add=s2.charAt(i);
        mp2.put(add,mp2.getOrDefault(add,0)+1);
       }
       return mp1.equals(mp2);
    }
    
}