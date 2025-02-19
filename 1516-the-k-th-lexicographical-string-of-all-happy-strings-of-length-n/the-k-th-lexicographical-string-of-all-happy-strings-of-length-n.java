class Solution {
    List<String>al=new ArrayList<>();
    public String getHappyString(int n, int k) {
        String curr="";
        generate(n,curr);
        if(al.size()<k) return "";
        Collections.sort(al);
        return al.get(k-1);       
        
    }
    void generate(int n,String curr){
        if(curr.length()==n) {
            al.add(curr);
            return ;
        }
        for(char ch='a';ch<='c';ch++){
            if(curr.length()>0 && ch==curr.charAt(curr.length()-1))continue;
            generate(n,curr+ch);


        }
    }
}