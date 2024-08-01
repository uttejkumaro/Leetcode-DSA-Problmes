/*
class Solution {
    public int countSeniors(String[] details) {
        //StringBUilder sb=new StringBUilder();
        int  count=0;
      for(String detail:details){
       int age=Integer.parseInt(detail.substring(11,13));
       if(age>60)count++;
      }
        return count;
    }
}
*/
class Solution {
    public int countSeniors(String[] details) {
        int count=0;
        for(String detail:details){
            int  tens=detail.charAt(11)-'0';
            int  ones=detail.charAt(12)-'0';
            int age =tens*10+ones;
            if(age>60)count++;
                 }
        return count;          
        
    }
}