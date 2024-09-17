class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String>res=new ArrayList<>();
        // char[]c1=s1.toCharArray();
        // char[]c2=s2.toCharArray();
        HashMap<String,Integer>mp=new HashMap<>();
        String []words1=s1.split(" ");
        String []words2=s2.split(" ");
        for(String word:words1) mp.put(word,mp.getOrDefault(word,0)+1);
        for(String word:words2) mp.put(word,mp.getOrDefault(word,0)+1);
        for( String w:mp.keySet()){
            if(mp.get(w)==1) res.add(w);
        }
        return res.toArray(new String[0]);
    }
}