class TrieNode {
    TrieNode[] store;
    boolean flag;

    public TrieNode() {
        store = new TrieNode[26];
        flag = false;

        for (int index = 0; index < 26; index++) {
            store[index] = null;
        }
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode curr = root;

        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.store[position] == null) {
                curr.store[position] = new TrieNode();
            }
            TrieNode nextNodeAddress = curr.store[position];
            curr = nextNodeAddress;
        }
        curr.flag = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        TrieNode curr = root;

        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.store[position] == null) {
                return false;
            }
            TrieNode nextNodeAddress = curr.store[position];
            curr = nextNodeAddress;
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode curr = root;

        for (int index = 0; index < n; index++) {
            int position = prefix.charAt(index) - 'a';
            if (curr.store[position] == null) {
                return false;
            }
            TrieNode nextNodeAddress = curr.store[position];
            curr = nextNodeAddress;
        }
        return true;
    }
}