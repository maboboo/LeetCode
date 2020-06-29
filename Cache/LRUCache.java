import java.util.HashMap;

/**
 * @author myb
 * @date 2020/6/27 15:38
 * @description LruCache
 */
public class LRUCache {

    // 最大容量
    private int cap;

    // key -> Node(key, val)
    private HashMap<Integer, Node> map;

    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new DoubleList();
        map = new HashMap<>();

    }

    /**
     * 根据 key 获取值，如果 key 不存在，返回 -1；
     * 如果存在，将 key 对应的 node 移动到链表头部，返回链表的值；
     * @param key
     * @return
     */
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else {
            Node node = map.get(key);
            cache.moveToFirst(node);
            return node.val;
        }
    }

    public void put(int key, int val){
        Node node = new Node(key, val);
        if(map.containsKey(key)){
            // 删除旧的，用新的覆盖，
            cache.remove(map.get(key));
            cache.addFirst(node);
            map.put(key, node);
        }else {
           if(cache.size() == cap){
               Node lastNode = cache.removeLast();
               // 高能预警，这里必须删掉 key
               map.remove(lastNode.key);
           }
            cache.addFirst(node);
            map.put(key, node);
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node() {
        }

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    class DoubleList {

        private Node head, tail;
        private int size;
        public DoubleList(){
            // 使用伪头部和伪尾部节点
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        /**
         * 往链表头部添加元素
         *
         * @param node
         */
        public void addFirst(Node node) {
            // head 伪头部节点，node 新增的真实的头部节点
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
            size++;
        }

        // 删除链表中的 x 节点（x 一定存在）
        // 由于是双链表且给的是目标 Node 节点，时间 O(1)

        /**
         *  删除链表中的 x 节点（x 一定存在）
         * @param node
         */
        public void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        /**
         * 删除链表尾部结点
         * @return 返回被删除的元素
         */
        public Node removeLast(){
            Node res = tail.prev;
            remove(res);
            return res;
        }

        /**
         * 将某个 node 移动到头部
         * @param node
         */
        public void moveToFirst(Node node){
            remove(node);
            addFirst(node);
        }

        // 返回链表长度，时间 O(1)
        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        /* 缓存容量为 2 */
        LRUCache cache = new LRUCache(2);
        // 你可以把 cache 理解成一个队列
        // 假设左边是队头，右边是队尾
        // 最近使用的排在队头，久未使用的排在队尾
        // 圆括号表示键值对 (key, val)
        cache.put(1, 1);
        // cache = [(1, 1)]
        cache.put(2, 2);
        // cache = [(2, 2), (1, 1)]
        cache.get(1);       // 返回 1
        // cache = [(1, 1), (2, 2)]
        // 解释：因为最近访问了键 1，所以提前至队头
        // 返回键 1 对应的值 1
        cache.put(3, 3);
        // cache = [(3, 3), (1, 1)]
        // 解释：缓存容量已满，需要删除内容空出位置
        // 优先删除久未使用的数据，也就是队尾的数据
        // 然后把新的数据插入队头
        cache.get(2);       // 返回 -1 (未找到)
        // cache = [(3, 3), (1, 1)]
        // 解释：cache 中不存在键为 2 的数据
        cache.put(1, 4);
        // cache = [(1, 4), (3, 3)]
        // 解释：键 1 已存在，把原始值 1 覆盖为 4
        // 不要忘了也要将键值对提前到队头
    }
}
