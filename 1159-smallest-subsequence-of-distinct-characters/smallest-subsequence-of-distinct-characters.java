class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        Deque<Character> st = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (visited[ch - 'a'])
                continue;
            while (!st.isEmpty() && st.peekLast() > ch && last[st.peekLast() - 'a'] > i) {
                visited[st.removeLast() - 'a'] = false;

            }
            st.addLast(ch);
            visited[ch - 'a'] = true;
        }

        String res = new String();
        while (!st.isEmpty())
            res += st.pop();
        return res;
    }
}