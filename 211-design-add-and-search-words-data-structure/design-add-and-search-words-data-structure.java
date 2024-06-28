class WordDictionary {
    private class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the WordDictionary.
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
    }
    
    // Searches for a word in the WordDictionary, '.' can match any character.
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }
    
    private boolean searchInNode(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (char ch : node.children.keySet()) {
                if (searchInNode(word, index + 1, node.children.get(ch))) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.children.containsKey(c)) {
                return false;
            }
            return searchInNode(word, index + 1, node.children.get(c));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
