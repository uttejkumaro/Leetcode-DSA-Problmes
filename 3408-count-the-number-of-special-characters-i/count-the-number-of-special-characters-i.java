// class Solution {
//     public int numberOfSpecialChars(String word) {
//         Set<Character> st = new HashSet<>();

//         for (char c : word.toCharArray()) {
//             st.add(c);
//         }

//         int count = 0;

//         for (char c = 'a'; c <= 'z'; c++) {
//             if (st.contains(c) && st.contains((char)(c - 32))) {
//                 count++;
//             }
//         }

//         return count;
//     }
// }
class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];

        for(char c : word.toCharArray()) {
            if(c >= 'a' && c <= 'z')
                lower[c - 'a'] = true;
            else
                upper[c - 'A'] = true;
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(lower[i] && upper[i])
                count++;
        }

        return count;
    }
}