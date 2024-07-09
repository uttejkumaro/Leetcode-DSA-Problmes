class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length(),n=num2.length();
        int prd[]=new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum=mul+prd[i+j+1];
                prd[i+j]+=sum/10;//carry
                prd[i+j+1]=sum%10;
            }
        }
        StringBuilder res = new StringBuilder();
        for(int digit :prd){
            if(!(res.length()==0 && digit==0 )){
                res.append(digit);
            }
        }
        return (res.length()==0)? "0" :res.toString();

        
    }
}