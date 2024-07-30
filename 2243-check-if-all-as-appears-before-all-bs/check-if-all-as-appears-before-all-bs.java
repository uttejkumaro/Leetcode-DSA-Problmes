/*
class Solution {
    public boolean checkString(String s) {
        boolean flag=false;
        for(char c:s.toCharArray()){
            if(c=='a'){
                if(flag){ //tells that a is presnt after b
                    return false;
                }
            }
            else if(c=='b'){
                flag=true;
            }

        }
        return true;
    }
}
*/
//2nd way 
class Solution {
    public boolean checkString(String s) {
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='b' && s.charAt(i+1)=='a') return false;
        }
        return true;
    }
}
