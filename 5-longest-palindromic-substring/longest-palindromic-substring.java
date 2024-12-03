import java.io.*;
import java.util.*;

public class Solution {
    static String longestPalindrome(String s){
        int n=s.length();
        int count=1;
        int start=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                
                if(ispali(s,i,j) && j-i+1>count){
                    start=i;
                    count=j-i+1;
                }
            }
            
        }
        return s.substring(start,start+count);
    }
    static boolean ispali(String s,int i,int j){
       while(i<j){
           if(s.charAt(i)!=s.charAt(j)) return false;
           i++;
           j--;
       }
        
        return true;
    }

    // public static void main(String[] args) {
    //    Scanner sc=new Scanner(System.in);
    //     String s=sc.next();
    //     System.out.println(pali(s));
        
    // }
}