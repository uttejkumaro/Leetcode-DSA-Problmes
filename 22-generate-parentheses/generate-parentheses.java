class Solution {
    public List<String> generateParenthesis(int n) {

        ArrayList<String>al=new ArrayList<>();
        gen(al,"",n,0,0);
        return al;
        
    }
    void gen(ArrayList<String>al,String curr,int n,int start,int end){
        if(curr.length()==2*n){
            al.add(curr);
            return;

        }
        if(start<n){
            gen(al,curr+"(",n,start+1,end);
        }
        if(end<start){
            gen(al,curr+")",n,start,end+1);
        }
    }
}