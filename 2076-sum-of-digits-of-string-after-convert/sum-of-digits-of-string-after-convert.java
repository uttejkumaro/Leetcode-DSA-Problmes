class Solution {
    public int getLucky(String s, int k) {
        StringBuilder res=new StringBuilder();
        for(char c:s.toCharArray()){
            int val=c-'a'+1;
            res.append(val);
        }
        int  sum=0;
       String num=res.toString();
        while(k-->0){
            sum=0;
            for(char c:num.toCharArray()){
                sum+=c-'0';
            }
            num=String.valueOf(sum);
            

        }
        return sum;

        
    }
}