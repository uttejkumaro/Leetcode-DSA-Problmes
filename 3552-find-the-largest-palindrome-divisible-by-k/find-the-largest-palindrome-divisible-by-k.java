class Solution {
    public String largestPalindrome(int n, int k) {
        if(k==1)
        return "9".repeat(n);
        else if(k==2){
            if(n==1) return "8";
            return "8"+"9".repeat(n-2)+"8"; 
        }
        else if(k==3){
        return "9".repeat(n);
            
        }
       else if(k==4){
         if(n<=3) return "8".repeat(n);
         return "88"+"9".repeat(n-4)+"88"; 
       }
       else if(k==5){
       if(n==1) return "5";
       return "5"+"9".repeat(n-2)+"5";       
       }
       else if(k==6){
        //should div by 2 and 3 last digit max-8
        if(n<=2) return "6".repeat(n);
        if(n%2==0){
            int l=n/2-2;
            return "8"+"9".repeat(l)+"77"+"9".repeat(l)+"8";
        }
        else{
            int l=n/2-1;
            return "8"+"9".repeat(l)+"8"+"9".repeat(l)+"8";

        }

       }
       else if(k==7){
        if(n%6==0) return "9".repeat(n);
        int rep=n/2;
        if(n%2 ==0) rep--;
        String pref="9".repeat(rep);
        String suff="9".repeat(rep);
        if(n%12==1 || n%12==5){
            return pref+"7"+suff;

        }
        else if(n%12==2 || n%12==4){
            return pref+"77"+suff;

        }
        else if(n%12==3) return pref+"5"+suff;
         else if(n%12==7 || n%12==11){
            return pref+"4"+suff;

        }

        else if(n%12==8 || n%12==10){
            return pref+"44"+suff;

        }
        else if(n%12==9) return pref+"6"+suff;






       }
       else if(k==8){
        //last 3 dig should div by 8
         if(n<=6) return "8".repeat(n);
         return "888"+"9".repeat(n-6)+"888"; 

       }
       else if(k==9){
        return "9".repeat(n);
       }
       return "-";

    }
}