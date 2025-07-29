class LRUCache {
    class Node {
        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    final int capacity;
    Map<Integer, Node> cache;
    final Node head, tail;;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;

        node.next = next;
        next.prev = node;

    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node existing = cache.get(key);
            existing.value = value;
            moveToFront(existing);
        } else {
            if (cache.size() >= capacity) {
                // Remove least recently used
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            Node newNode = new Node(key, value);
            addToFront(newNode);
            cache.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */