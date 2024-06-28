import java.util.HashMap;
import java.util.Map;

public class Trie {
    Map<Character, Trie> child = new HashMap<>();
    boolean isEnd = false;

    public Trie() {
        // The constructor doesn't need to do anything additional in this implementation.
    }
    
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node.child.putIfAbsent(c, new Trie());
            node = node.child.get(c);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            node = node.child.get(c);
            if (node == null) {
                return false;
            }
        }
        return node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (char c : prefix.toCharArray()) {
            node = node.child.get(c);
            if (node == null) {
                return false;
            }
        }
        return true;
    }
}
