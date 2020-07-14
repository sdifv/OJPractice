//给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return backtrace(s, wordDict);
    }

    public boolean backtrace(String s, List<String> wordDict){
        if(s.length() == 0){
            return true;
        }

        for(String word: wordDict){
            if(s.startsWith((word))){
                String sub = s.substring(word.length(),s.length());
                while(sub.startsWith(word)){
                    sub = sub.substring(word.length(), sub.length());
                }
                // 如果剩余字串能够拆分，即可结束搜索
                if(backtrace(sub,wordDict)){
                    return true;
                }
                // 否则当前拆分不合理,需要尝试下一个word
            }
        }
        // 当前所有的尝试和字串的搜索全部不满足，证明不能拆分
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
