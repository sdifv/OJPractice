package dataStruct;

class Trie {

  int count;  // 以当前单词结尾的单词数量
  int prefix; // 以该处节点之前的字符串为前缀的单词数量
  Trie[] next = new Trie[26];

  /** Initialize your data structure here. */
  public Trie() {
    count = 0;
    prefix = 0;
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    if(word.length()==0){
      return;
    }
    char[] charArray = word.toCharArray();
    Trie root = this;

    for(int i=0; i<word.length(); i++){
      int branch = charArray[i]-'a';
      // 检查charArray[i]节点是否已经存在
      if(root.next[branch]==null){
        root.next[branch] = new Trie();
      }
      root = root.next[branch];
      root.prefix++;
    }
    root.count++;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    if(word.length()==0){
      return false;
    }
    char[] charArray = word.toCharArray();
    Trie root = this;
    for (int i = 0; i < word.length(); i++) {
      int branch = charArray[i] - 'a';
      if(root.next[branch] == null){
        return false;
      }
      root = root.next[branch];
    }
    if(root.count == 0){
      return false;
    }else{
      return true;
    }
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    if(prefix.length()==0){
      return false;
    }
    char[] charArray = prefix.toCharArray();
    Trie root = this;
    for (int i = 0; i < prefix.length(); i++) {
      int branch = charArray[i] - 'a';
      if(root.next[branch] == null){
        return false;
      }
      root = root.next[branch];
    }
    if(root.prefix == 0){
      return false;
    }else{
      return true;
    }
  }
  public static void main(String[] args){
  }
}