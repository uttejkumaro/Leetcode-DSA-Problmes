import java.util.*;

class LFUCache {
    private int capacity;
    private int minFreq;
    private Map<Integer, Node> keyToNode;
    private Map<Integer, LinkedHashSet<Node>> freqToNodes;

    private static class Node {
        int key, value, freq;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToNode = new HashMap<>();
        freqToNodes = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;
        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyToNode.size() >= capacity) {
                // Remove LFU node
                LinkedHashSet<Node> nodes = freqToNodes.get(minFreq);
                Node toRemove = nodes.iterator().next();
                nodes.remove(toRemove);
                keyToNode.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            freqToNodes.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(newNode);
            minFreq = 1;
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        LinkedHashSet<Node> nodes = freqToNodes.get(oldFreq);
        nodes.remove(node);

        if (oldFreq == minFreq && nodes.isEmpty()) {
            minFreq++;
        }

        node.freq++;
        freqToNodes.computeIfAbsent(node.freq, k -> new LinkedHashSet<>()).add(node);
    }
}
