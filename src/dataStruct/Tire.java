package dataStruct;

class Trie {

    public Trie[] children;
    public boolean isEnd;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }


    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie node = this;
        char[] charArr = word.toCharArray();
        for (char aCharArr : charArr) {
            int index = aCharArr - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    /**
     * 从字典树的根开始，查找前缀。
     * <p>
     * 对于当前字符对应的子节点，有两种情况：
     * 子节点存在。沿着指针移动到子节点，继续搜索下一个字符。
     * 子节点不存在。说明字典树中不包含该前缀，返回空指针。
     * 重复以上步骤，直到返回空指针或搜索完前缀的最后一个字符。
     * 存在则返回   true ;
     * 不存在则返回 false;
     */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /**
     * 搜索前缀
     *
     * @param prefix 前缀
     * @return 结点
     */
    private Trie searchPrefix(String prefix) {
        Trie node = this;
        char[] charArr = prefix.toCharArray();
        for (char item : charArr) {
            int index = item - 'a';
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {
    }
}