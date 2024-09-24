class TrieNode {
    boolean isEnd;
    Map<Character, TrieNode> children;
    
    TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }
}
class Trie {
    TrieNode root;
        Trie() {
        root = new TrieNode();
    }    
    // Insert a string into the Trie
    void insert(String str) {
        TrieNode currentNode = root;
        for (char ch : str.toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                currentNode.children.put(ch, new TrieNode());
            }
            currentNode = currentNode.children.get(ch); 
        }
        currentNode.isEnd = true;
    }
        // Find the prefix length of a string
    int prefix(String str) {
        TrieNode currentNode = root;
        int length = 0;
        for (char ch : str.toCharArray()) {
            if (!currentNode.children.containsKey(ch)) break;
            currentNode = currentNode.children.get(ch); 
            length++;
        }
        return length;
    }
}
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();        
        // Insert each number from arr1 into the Trie as a string
        for (int num : arr1) {
            trie.insert(Integer.toString(num));
        }        
        int maxPrefixLength = 0;
        
        // Find the maximum prefix length for each number in arr2
        for (int num : arr2) {
            maxPrefixLength = Math.max(maxPrefixLength, trie.prefix(Integer.toString(num)));
        }        
        return maxPrefixLength;
    }
}
