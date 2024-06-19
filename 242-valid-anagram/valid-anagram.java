/* 2 approaches
1.hashmap
2.sorting and compare
*/

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

