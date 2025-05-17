class TrieNode{
    TrieNode store[];
    boolean flag;
    TrieNode(){
        store=new TrieNode[26];
        flag =false;
        //Arrays.fill(store,null);
    }
}
class Trie{
    TrieNode root;
    Trie(){
        root=new TrieNode();
    }
    void insert(String word){
        int n=word.length();
        TrieNode curr=root;
        for(int idx=0;idx<n;idx++){
            int pos=word.charAt(idx)-'a';
            if(curr.store[pos]==null) {
                curr.store[pos]=new TrieNode();
            }
            TrieNode nextNodeAdress=curr.store[pos];
            curr=nextNodeAdress; 
        }
        curr.flag=true;
    }
    boolean search(String word) {
        int n=word.length();
        TrieNode curr=root;
        for(int idx=0;idx<n;idx++){
            int pos=word.charAt(idx)-'a';
            if(curr.store[pos]==null) {
                return false;
            }
            TrieNode nextNodeAdress=curr.store[pos];
            curr=nextNodeAdress; 
        }
        return curr.flag;
    
    }
    boolean startsWith(String prefix) {
        int n=prefix.length();
        TrieNode curr=root;
        for(int idx=0;idx<n;idx++){
            int pos=prefix.charAt(idx)-'a';
            if(curr.store[pos]==null) {
                return false;
            }
            TrieNode nextNodeAdress=curr.store[pos];
            curr=nextNodeAdress; 
        }
        return true;
    
    }
}
/**
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> store;
    boolean flag;

    public TrieNode() {
        store = new HashMap<>();
        flag = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            curr.store.putIfAbsent(ch, new TrieNode());
            curr = curr.store.get(ch);
        }
        curr.flag = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.store.containsKey(ch)) return false;
            curr = curr.store.get(ch);
        }
        return curr.flag;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            if (!curr.store.containsKey(ch)) return false;
            curr = curr.store.get(ch);
        }
        return true;
    }
}
 */