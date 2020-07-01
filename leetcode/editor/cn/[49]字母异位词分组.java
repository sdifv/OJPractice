//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s:strs){
            String mark = markWord(s);
            if(!map.keySet().contains(mark)){
                List<String> wordList = new ArrayList<>();
                wordList.add(s);
                map.put(mark, wordList);
            }else{
                map.get(mark).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }

    public String markWord(String s){
        int[] mark = new int[26];
        Arrays.fill(mark, 0);
        for (int i = 0; i <s.length() ; i++) {
            int index = s.charAt(i) - 'a';
            mark[index]++;
        }
        return Arrays.toString(mark);
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        String[] str = {"eat","tea","tan","ate","nat","bat"};
//        s.groupAnagrams(str);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
