// class Solution {
//     public int repeatedStringMatch(String a, String b) {
//         StringBuilder s = new StringBuilder(a);
//         int q = 1;
//         for (; s.length() < b.length(); q++) {//O(n(n+m))
//             s.append(a);
//         }
//         if (s.indexOf(b) >= 0)
//             return q;//index of takes O(n+m)
//         if (s.append(a).indexOf(b) >= 0)
//             return q + 1;

//         return -1;

//     }
// }
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int q = 1;
        StringBuilder s = new StringBuilder(a);
        while (s.length() < b.length()) {
            s.append(a);
            q++;
        }
        if (kmpSearch(s.toString(), b))
            return q;
        s.append(a);
        if (kmpSearch(s.toString(), b))
            return q + 1;
        return -1;
    }

    boolean kmpSearch(String s, String b) {
        int lps[] = compute(b);
        int i = 0, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == b.charAt(j)) {
                i++;
                j++;
                if (j == b.length())
                    return true;
            } else {

                if (j > 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return false;
    }

    int[] compute(String b) {
        int n = b.length();
        int lps[] = new int[n];
        int j = 0;
        for (int i = 1; i < n;) {
            if (b.charAt(i) == b.charAt(j))
                lps[i++] = ++j;
            else {
                if (j > 0)
                    j = lps[j - 1];
                else
                    lps[i++] = 0;
            }
        }
        return lps;

    }
}