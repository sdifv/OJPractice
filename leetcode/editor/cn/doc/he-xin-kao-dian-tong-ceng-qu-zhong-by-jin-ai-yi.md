### 解题思路
 [QQ截图20200609181918.png](https://pic.leetcode-cn.com/92a2c34ab0484175b9263f94821e36ed013451d2add91ac534b200fc50b9bdf9-QQ%E6%88%AA%E5%9B%BE20200609181918.png)

无论是求组合/子集/排列，只要原数组中含有重复元素，通用一个去重方法：
1.先排序，使相同元素相邻；
2.在backtrack的for循环里：
```java
if(i>start&&candidates[i]==candidates[i-1]) continue;
```
其中i>start一定要理解，i是当前考察的元素下标，start是**本层**最开始的那个元素的下标，我们的去重是要**同层去重**，
如果你只写candidates[i]==candidates[i-1]这一个判断条件，那么在dfs树的时候，身处不同层的相同元素的组合/排列也都生成不了

这一点一定要理解，同样考察“同层去重”的题目还有：[90. 子集 II](https://leetcode-cn.com/problems/subsets-ii/)

同层去重的好题解有很多，比如这篇：
[子集 I 到 子集 II 剪枝的思路](https://leetcode-cn.com/problems/subsets-ii/solution/jian-zhi-qu-zhong-de-si-lu-by-mrsate/)


### 代码

```java
class Solution {
   ArrayList<List<Integer>> res=new ArrayList<>();
    ArrayList<Integer> one_answer=new ArrayList<>();
    int[] candidates;
    int target;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates=candidates;
        this.target=target;
        this.n=candidates.length;
        Arrays.sort(candidates);
        backtrack(0,0);
        return res;
    }
    private void backtrack(int start,int path_sum){//即将往one_answer里填入第start个元素candidates[start]
         if(path_sum>=target){//因为数组元素都是正整数，path_sum不可能减少
            return;
        }
        for(int i=start;i<n;i++){//组合，从当前元素开始循环
            if(i>start&&candidates[i]==candidates[i-1]){continue;}
            one_answer.add(candidates[i]);
            if(path_sum+candidates[i]==target) {res.add(new ArrayList<>(one_answer));}
            backtrack(i+1,path_sum+candidates[i]);
            one_answer.remove(one_answer.size()-1);
        }
    }
}

```