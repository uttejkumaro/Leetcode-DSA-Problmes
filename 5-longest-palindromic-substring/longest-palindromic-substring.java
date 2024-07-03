class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        
        if (n <= 1) {
            return s;
        }

        String lps = "";
        
        // Odd length palindromes
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            
            String palindrome = s.substring(l + 1, r);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }
        }
        
        // Even length palindromes
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int r = i;
            
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            
            String palindrome = s.substring(l + 1, r);
            if (palindrome.length() > lps.length()) {
                lps = palindrome;
            }
        }
        
        return lps;
    }
}

/*
class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
    if (n == 1) {
        return s;
    }
    
    String lps = "";
    
    // Odd-length palindromes
    for (int i = 0; i < n; i++) {
        int left = i, right = i;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > lps.length()) {
                lps = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }
    
    // Even-length palindromes
    for (int i = 0; i < n - 1; i++) {
        int left = i, right = i + 1;
        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > lps.length()) {
                lps = s.substring(left, right + 1);
            }
            left--;
            right++;
        }
    }
    
    return lps;
}
}
*/

