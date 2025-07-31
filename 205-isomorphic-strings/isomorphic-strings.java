import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> charMap = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replace = t.charAt(i);
            
            if(!charMap.containsKey(original)) {
                if(charMap.containsValue(replace)) {
                    return false;
                }
                charMap.put(original, replace);
            } else {
                char mappedChar = charMap.get(original);
                if(mappedChar != replace) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
/**
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] mapS = new int[256];  // ASCII size
        int[] mapT = new int[256];

        for(int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(mapS[cs] != mapT[ct]) return false;

            // Store position +1 to avoid default 0 confusion
            mapS[cs] = i + 1;
            mapT[ct] = i + 1;
        }

        return true;
    }
}
 */