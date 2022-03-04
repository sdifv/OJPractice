import java.util.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 第 1 步：先将 wordList 放到哈希表里，便于判断某个单词是否在 wordList 里
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);

        // 第 2 步：图的广度优先遍历，必须使用队列和表示是否访问过的 visited 哈希表
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 第 3 步：开始广度优先遍历，包含起点，因此初始化的时候步数为 1
        int step = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                // 依次遍历当前队列中的单词
                String currentWord = queue.poll();
                // 如果 currentWord 能够修改 1 个字符与 endWord 相同，则返回 step + 1
                int sz = endWord.length();
                char[] arr = currentWord.toCharArray();
                // 第 4 步：对 currentWord 的每一位都尝试修改，对修改后的结果进行判断
                for (int j = 0; j < sz; j++) {
                    char origin = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == origin) continue;
                        arr[j] = c;
                        String newWord = String.valueOf(arr);
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            } else {
                                if (!visited.contains(newWord)) {
                                    queue.offer(newWord);
                                    visited.add(newWord);
                                }
                            }
                        }
                    }
                    arr[j] = origin;
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> wordList = new ArrayList<>(Arrays.asList("cog", "hot", "dot", "dog", "lot", "log"));
        System.out.println(s.ladderLength("hit", "cog", wordList));
        String str = "123 ";
    }
}