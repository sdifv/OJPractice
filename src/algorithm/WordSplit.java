package algorithm;

import java.util.*;

public class WordSplit {
    List<String> ans;
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        ans = new ArrayList<>();
        LinkedList<String> words = new LinkedList<>();
        backtrace(s, 0, words, wordSet);
        return ans;
    }

    private void backtrace(String s, int i, LinkedList<String> words, Set<String> wordSet) {
        if(i > s.length()) return;
        if(i == s.length()){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < words.size() - 1; j++) {
                sb.append(words.get(j)).append(" ");
            }
            sb.append(words.get(words.size() - 1));
            ans.add(sb.toString());
            return;
        }
        String subStr = s.substring(i);
        for (String item : wordSet) {
            if(subStr.startsWith(item)){
                words.addLast(item);
                backtrace(s, i + item.length(), words, wordSet);
                words.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        WordSplit ws = new WordSplit();
        System.out.println(ws.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
