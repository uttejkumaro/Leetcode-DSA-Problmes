class Solution {
    class TrieNode {
        TrieNode[] children;
        int count;        
        TrieNode() {
        children = new TrieNode[26]; // since words consist of lowercase English  letters
        count = 0;
        }
    }
    
    class Trie {
        TrieNode root;        
        Trie() {
            root = new TrieNode();
        }       
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.count++; 
            }
        }
        int getScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                node = node.children[idx];
                score += node.count; 
            }
            return score;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] result = new int[n];
        Trie trie = new Trie();        
       for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < n; i++) {
            result[i] = trie.getScore(words[i]);
        }
        
        return result;
    }
}
