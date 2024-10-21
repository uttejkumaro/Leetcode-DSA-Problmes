class Solution {
    public int maxUniqueSplit(String s) {
        Set<String>set=new HashSet<>();
        return helper(s,0,set);
        }
        int helper(String s,int begin,Set<String>set){
            if(begin==s.length()) return 0;
            int max=0;
            for(int e=begin+1;e<=s.length();e++){
                //recursive add max count function
                String sub=s.substring(begin,e);
                if(!set.contains(sub)){
                    set.add(sub);
                    max=Math.max(max,1+helper(s,e,set));
                    //remove
                    set.remove(sub);
                }
            }
            return max;
        }
}