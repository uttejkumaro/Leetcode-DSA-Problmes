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
/**
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        generate(result, sb, n, 0, 0);
        return result;
    }

    private void generate(List<String> result, StringBuilder curr, int n, int open, int close) {
        if (curr.length() == 2 * n) {
            result.add(curr.toString());
            return;
        }

        if (open < n) {
            curr.append('(');
            generate(result, curr, n, open + 1, close);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }

        if (close < open) {
            curr.append(')');
            generate(result, curr, n, open, close + 1);
            curr.deleteCharAt(curr.length() - 1); // backtrack
        }
    }
}
 */