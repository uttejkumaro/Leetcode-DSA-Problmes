class Solution {
    public int openLock(String[] deadends, String target) {
        // password we have to avoid
        Set<String> deads = new HashSet<>();
        for (String s : deadends)
            deads.add(s);

        // record those password we already visited
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        // BFS structure
        // while => level by level, for => traversing current level
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (deads.contains(curr))
                    continue;
                if (curr.equals(target))
                    return step;

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curr, j);
                    String down = minusOne(curr, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}