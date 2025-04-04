class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder s = new StringBuilder(a);
        int q = 1;
        for (; s.length() < b.length(); q++) {//O(n(n+m))
            s.append(a);
        }
        if (s.indexOf(b) >= 0)
            return q;//index of takes O(n+m)
        if (s.append(a).indexOf(b) >= 0)
            return q + 1;

        return -1;

    }
}