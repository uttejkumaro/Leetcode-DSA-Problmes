// import java.util.HashMap;

// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         if(s.length() != t.length()) {
//             return false;
//         }
        
//         HashMap<Character, Character> charMap = new HashMap<>();
        
//         for(int i = 0; i < s.length(); i++) {
//             char original = s.charAt(i);
//             char replace = t.charAt(i);
            
//             if(!charMap.containsKey(original)) {
//                 if(charMap.containsValue(replace)) {
//                     return false;
//                 }
//                 charMap.put(original, replace);
//             } else {
//                 char mappedChar = charMap.get(original);
//                 if(mappedChar != replace) {
//                     return false;
//                 }
//             }
//         }
        
//         return true;
//     }
// }

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
 /**
 Yes, using mapS[char] = i + 1 effectively stores the index at which the character was seen, with a small offset.
 import java.util.HashMap;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // Get last seen index (default 0 if not seen before)
            int lastS = mapS.getOrDefault(cs, 0);
            int lastT = mapT.getOrDefault(ct, 0);

            // If mapping is inconsistent, not isomorphic
            if (lastS != lastT) return false;

            // Update last seen index (+1 to avoid confusion with default 0)
            mapS.put(cs, i + 1);
            mapT.put(ct, i + 1);
        }

        return true;
    }
}


 */