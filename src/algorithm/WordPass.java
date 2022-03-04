package algorithm;

import java.util.*;

public class WordPass {
    int ans = Integer.MAX_VALUE;
    Map<String, List<String>> match = new HashMap<>();
    String endWord;
    List<String> wordList;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        this.endWord = endWord;
        this.wordList = wordList;
        List<String> vis = new LinkedList<>();
        dfs(beginWord, 0, vis);
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }

    private void dfs(String word, int cnt, List<String> vis){
        if(word.equals(endWord)){
            System.out.println(vis);
            ans = Math.min(ans, cnt);
            return;
        }
        List<String> needMatch;
        if(match.containsKey(word)){
            needMatch = match.get(word);
        }else{
            needMatch = matchOptions(word);
            match.put(word, needMatch);
        }

        for(String item : needMatch){
            if(!vis.contains(item)){
                vis.add(item);
                dfs(item, cnt+1, vis);
                vis.remove(item);
            }
        }
    }

    private List<String> matchOptions(String word){
        List<String> ans = new ArrayList<>();
        for(String item : this.wordList){
            if(item.equals(word))
                continue;
            int sz = word.length();
            int diffNum = 0;
            boolean flag = true;
            for(int i=0; i<sz; i++){
                if(item.charAt(i) != word.charAt(i)){
                    diffNum++;
                    if(diffNum == 2){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) ans.add(item);
        }
        return ans;
    }

    public static void main(String[] args) {
        WordPass wp = new WordPass();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(wp.ladderLength("hit", "cog", wordList));
    }
}
