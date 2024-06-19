/* 2 approaches
1.hashmap
2.sorting and compare
*/
/*
class Solution {
    public boolean isAnagram(String s, String t) {
    int n=s.length();
    int m=t.length();
    if (n!=m){
        return false;
    }
    char a[]=s.toCharArray();
    char b[]=t.toCharArray();
    Arrays.sort(a);
    Arrays.sort(b);
    int i=0;
    int j=0;

    while(i<n && j<m){// O(nlogn),O(n)
        if (a[i]!=b[j]){
        return false;
        }
           i++;
           j++;
    }
 
    return true; 
    }
} 


//using Hashmap
class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if (n!=m){
            return false;
        }
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char schar=s.charAt(i);
            char tchar=t.charAt(i);
            map.put(schar,map.getOrDefault(schar, 0) + 1);
            map.put(tchar,map.getOrDefault(tchar, 0) -1);

        }
            for(int i:map.values()){
            if (i!=0){
                 return false;
                }
            }
        return true;
        
   }
}
    */

    

//using char count
class Solution {
    public boolean isAnagram(String s, String t) {
    int n=s.length();
    int m=t.length();
    if (n!=m){
        return false;
    }
    int count[]=new int[26];
    for(int i=0;i<n;i++){
        count[s.charAt(i)-'a']++;
        count[t.charAt(i)-'a']--;

    }
    for(int i:count){
        if (i!=0){
            return false;
        }
    }
    return true;
    }  
    
}


