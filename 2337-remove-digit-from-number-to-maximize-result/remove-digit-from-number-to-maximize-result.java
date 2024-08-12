class Solution {
    public String removeDigit(String number, char digit) {
        String num=" ";
        for(int i=0;i<number.length();i++){
            if(number.charAt(i)==digit){
                String  newNum=number.substring(0,i)+number.substring(i+1,number.length());
                 if(newNum.compareTo(num)>0){
                    num=newNum;

                }
            }
           
        }
        return num;        
    }
}