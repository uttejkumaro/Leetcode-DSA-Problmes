class Solution {
    public boolean areNumbersAscending(String s) {
        int last=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            StringBuilder sb=new StringBuilder();
            int j=i;
            while(j<s.length() && s.charAt(j)>='0' && s.charAt(j)<='9'){
                sb.append(s.charAt(j++));


            }
            i=j;
            if(sb.length()>0){ //digits are present
            int num=Integer.parseInt(sb.toString());
            if(num<=last)return false;
            last=num;


            }
        }
        return true;
        
    }
}