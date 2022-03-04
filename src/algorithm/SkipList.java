package algorithm;

public class SkipList {
    static class Node {
        // 最大层数
        public static int DEFAULT_MAX_LEVEL = 32;
        /**
         * 随机层数概率，也就是随机出的层数，在第 1 层以上(不包括第一层)的概率，
         * 层数不超过 maxLevel，层数的起始号为 1
         */
        public static double DEFAULT_P_FACTOR = 0.25;

        int value;
        Node[] next;

        public Node(int value, int size) {
            this.value = value;
            next = new Node[size];
        }

        public Node(int value) {
            this(value, randomLevel());
        }

        private static int randomLevel() {
            int level = 1;
            while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) {
                level++;
            }
            return level;
        }
    }

    private Node head; // 头节点
    private int currentLevel; // 实际层数，从 1 开始

    public SkipList() {
        head = new Node(-1, Node.DEFAULT_MAX_LEVEL);
        currentLevel = 1;
    }

    public boolean search(int target) {
        Node node = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            node = findClosest(node, i, target);
            if (node.next[i] != null && node.next[i].value == target) {
                return true;
            }
        }
        return false;
    }

    public void add(int num) {
        Node updateNode = head;
        Node newNode = new Node(num);
        int level = newNode.next.length;
        // 计算出当前 num 索引的实际层数，从该层开始添加索引
        for (int i = currentLevel - 1; i >= 0; i--) {
            updateNode = findClosest(updateNode, i, num);
            if (i < level) {
                // 插入节点
                newNode.next[i] = updateNode.next[i];
                updateNode.next[i] = newNode;
            }
        }

        // 如果随机出来的层数比当前的层数还大，那么超过 currentLevel 的 head 直接指向 newNode
        if (level > currentLevel) {
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }

            // 更新当前实际层数
            currentLevel = level;
        }
    }

    public boolean erase(int num) {
        boolean flag = false;
        Node node = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            node = findClosest(node, i, num);
            if (node.next[i] != null && node.next[i].value == num) {
                flag = true;
                node.next[i] = node.next[i].next[i];
            }
        }
        return flag;
    }

    // 找到 level 层第一个大于或者等于 target 的结点
    // 注意，是从头结点开始进行判断
    private Node findClosest(Node node, int level, int target) {
        while (node.next[level] != null && node.next[level].value < target) {
            node = node.next[level];
        }
        return node;
    }
}
