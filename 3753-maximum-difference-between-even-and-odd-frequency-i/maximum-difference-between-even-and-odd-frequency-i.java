class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer>map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int min_even=Integer.MAX_VALUE;
        int max_odd=Integer.MIN_VALUE;
        for(int i:map.values()){
            if(i%2==0){
                min_even=Math.min(min_even,i);
            }
            else{
                max_odd=Math.max(max_odd,i);
            }
        }
        return max_odd-min_even;
        
    }
}