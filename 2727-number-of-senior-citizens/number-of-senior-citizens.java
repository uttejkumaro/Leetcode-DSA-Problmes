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