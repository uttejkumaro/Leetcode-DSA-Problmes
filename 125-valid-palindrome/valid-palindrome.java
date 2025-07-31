class Solution {
    public boolean isPalindrome(String s) {
        
        if (s==null){
            return false;
        }
//         StringBuilder filteredString =new StringBuilder();
//         for(char c:s.toCharArray()){
//             if(Character.isLetterOrDigit(c)){
//                 filteredString.append(Character.toLowerCase(c)); 
//             }
//         }
//          // If the filtered string is empty, it is considered a palindrome
//         if (filteredString.length() == 0) {
//             return true;
//         }

//    // Use two pointers to check if the filtered string is a palindrome
//         int left = 0;
//         int right = filteredString.length() - 1;
//         while (left < right) {
//             if (filteredString.charAt(left) != filteredString.charAt(right)) {
//                 return false;
//             }
//             left++;
//             right--;
//         }

//         return true;
    s=s.toLowerCase();
    int l=0;
    int r=s.length()-1;
        while(l<r){
            while(l<r && !Character.isLetterOrDigit(s.charAt(l)))l++;
            while(l<r && !Character.isLetterOrDigit(s.charAt(r)))r--;
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;r--;
        }
        return true;
    }
}