class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer>mp=new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
           int first=mp.get(s.charAt(i));
          int second = (i + 1 < n) ? mp.get(s.charAt(i + 1)) : 0; 
            if((first)<(second)){
                res-=(first);
            }
            else{
                res+=(first);
            }
        }
        return res;
        
    }
}