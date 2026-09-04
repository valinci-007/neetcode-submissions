class Node {
    int key, val;
    Node prev, next;
    Node(int key, int val) { this.key = key; this.val = val; }
}

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache = new HashMap<>();
    private final Node head, tail; // head = MRU side, tail = LRU side (dummies)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        remove(node);
        insertFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {          // update: refresh value + move to front
            node.val = value;
            remove(node);
            insertFront(node);
            return;
        }
        if (cache.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            cache.remove(lru.key);
        }
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insertFront(newNode);
    }
}