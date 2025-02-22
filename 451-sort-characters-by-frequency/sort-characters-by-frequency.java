class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>mp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        List<Character>al=new ArrayList<>(mp.keySet());
        Collections.sort(al,(a,b)->mp.get(b)-mp.get(a));
        StringBuilder res=new StringBuilder();
        for(char c:al){
            int limit=mp.get(c);
            for(int i=0;i<limit;i++){
                res.append(c);
            }
        } 
        return res.toString();      
        
    }
}