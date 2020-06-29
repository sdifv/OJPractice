这道题与上一问的区别在于：

+ [第 39 题]((https://leetcode-cn.com/problems/combination-sum/))：candidates 中的数字可以无限制重复被选取。
+ 第 40 题：candidates 中的每个数字在每个组合中只能使用一次。

编码的不同在于下一层递归的起始索引不一样。

+ 第 39 题：还从候选数组的当前索引值开始。
+ 第 40 题：从候选数组的当前索引值的下一位开始。

相同之处：解集不能包含重复的组合。 

为了使得解集不包含重复的组合。我们想一想，**如何去掉一个数组中重复的元素**，除了使用哈希表以外，我们还可以**先对数组升序排序，重复的元素一定不是排好序以后的第 1 个元素和相同元素的第 1 个元素**。根据这个思想，我们先对数组升序排序是有必要的。候选数组有序，对于在递归树中发现重复分支，进而“剪枝”也是有效的。

**思路分析**：

这道题其实比上一问更简单，思路是：

> 以 target 为根结点，依次减去数组中的数字，直到小于 *0* 或者等于 *0*，把等于 *0* 的结果记录到结果集中。

当然你也可以以 *0* 为根结点，依次加上数组中的数字，直到大于 target 或者等于 target，把等于 target 的结果记录到结果集中。


+ “解集不能包含重复的组合”，就提示我们得对数组先排个序（**“升序”或者“降序”均可**，下面示例中均使用“升序”）。
+ “candidates 中的每个数字在每个组合中只能使用一次”，那就按照顺序依次减去数组中的元素，递归求解即可：遇到 *0* 就结算且回溯，遇到负数也回溯。
+ `candidates` 中的数字可以重复，可以借助「力扣」第 47 题：[“全排列 II”](https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/) 的思想，在搜索的过程中，找到可能发生重复结果的分支，把它剪去。


（温馨提示：下面的幻灯片中，有几页上有较多的文字，可能需要您停留一下，可以点击右下角的后退 “|◀” 或者前进 “▶|” 按钮控制幻灯片的播放。）

  [40-1.png](https://pic.leetcode-cn.com/5a8ad63b91ea09d46ac0b44cbf3325c2a3c2199ec232ec562135fbcf2ea9e70d-40-1.png)  [40-2.png](https://pic.leetcode-cn.com/a470bcb582807c465ec03accfb29f204caab1438750e6fc5b029eb22700d7079-40-2.png) 


**参考代码 1**：以 target 为根结点，依次减去数组中的数字，直到小于 *0* 或者等于 *0*，把等于 *0* 的结果记录到结果集中。

感谢用户 [@rmokerone](/u/rmokerone/) 提供的 C++ 版本的参考代码。


```Java []
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {

    /**
     * @param candidates 候选数组
     * @param len
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param residue    表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(int[] candidates, int len, int begin, int residue, Deque<Integer> path, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            // 小剪枝
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, residue - candidates[i], path, res);

            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }
}
```
```Python []
from typing import List


class Solution:

    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        def dfs(begin, path, residue):
            if residue == 0:
                res.append(path[:])
                return

            for index in range(begin, size):
                if candidates[index] > residue:
                    break

                if index > begin and candidates[index - 1] == candidates[index]:
                    continue

                path.append(candidates[index])
                dfs(index + 1, path, residue - candidates[index])
                path.pop()

        size = len(candidates)
        if size == 0:
            return []

        candidates.sort()
        res = []
        dfs(0, [], target)
        return res
```
```C++ []
// author:rmokerone
#include <iostream>
#include <vector>

using namespace std;

class Solution {

private:
    vector<int> candidates;
    vector<vector<int>> res;
    vector<int> path;
public:
    void DFS(int start, int target) {
        if (target == 0) {
            res.push_back(path);
            return;
        }

        for (int i = start; i < candidates.size() && target - candidates[i] >= 0; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            path.push_back(candidates[i]);
            // 元素不可重复利用，使用下一个即i+1
            DFS(i + 1, target - candidates[i]);
            path.pop_back();
        }
    }

    vector<vector<int>> combinationSum2(vector<int> &candidates, int target) {
        sort(candidates.begin(), candidates.end());
        this->candidates = candidates;
        DFS(0, target);
        return res;
    }
};
```


这里按照用户 [@Aspire](/u/aspire-6) 提供的思路，给出从 *0* 开始，一个使用加法，搜索加到目标数的写法，“前提是排序（升序降序均可）”，然后“剪枝”的操作和上面一样。


 [40-3.png](https://pic.leetcode-cn.com/905c5e4df393a43890932903a5234e51048bc9a0a3aa7f3fc4fb0a65535e6a0b-40-3.png)

**参考代码 2**：以 *0* 为根结点，依次加上数组中的数字，直到大于 target 或者等于 target，把等于 target 的结果记录到结果集中。

```C++ []
#include <iostream>
#include <vector>
#include <map>

using namespace std;

class Solution {
public:

    vector<int> input;
    int target;
    vector<vector<int>> result;
    vector<int> vc;

    void dfs(int index, int sum) {
        // index >= input.size() ，写成 index == input.size() 即可
        // 因为每次都 + 1，在 index == input.size() 剪枝就可以了
        if (sum >= target || index == input.size()) {
            if (sum == target) {
                result.push_back(vc);
            }
            return;
        }
        for (int i = index; i < input.size(); i++) {
            if (input[i] > target) {
                continue;
            }

            // 【我添加的代码在这里】：
            // 1、i > index 表明剪枝的分支一定不是当前层的第 1 个分支
            // 2、input[i - 1] == input[i] 表明当前选出来的数等于当前层前一个分支选出来的数
            // 因为前一个分支的候选集合一定大于后一个分支的候选集合
            // 故后面出现的分支中一定包含了前面分支出现的结果，因此剪枝
            // “剪枝”的前提是排序，升序或者降序均可
            if (i > index && input[i - 1] == input[i]) {
                continue;
            }

            vc.push_back(input[i]);
            sum += input[i];
            dfs(i + 1, sum);
            vc.pop_back();
            sum -= input[i];
        }
    }

    vector<vector<int>> combinationSum2(vector<int> &candidates, int target) {
        // “剪枝”的前提是排序，升序或者降序均可
        sort(candidates.begin(), candidates.end());
        this->input = candidates;
        this->target = target;
        dfs(0, 0);
        return result;
    }
};


int main() {
    cout << "LeetCode 第 40 题：组合问题 II" << endl;
    Solution solution = Solution();

    vector<int> candidates;
    candidates.push_back(10);
    candidates.push_back(1);
    candidates.push_back(2);
    candidates.push_back(7);
    candidates.push_back(6);
    candidates.push_back(1);
    candidates.push_back(5);

    int target = 8;
    vector<vector<int>> res = solution.combinationSum2(candidates, target);
    for (int i = 0; i < res.size(); ++i) {
        for (int j = 0; j < res[i].size(); ++j) {
            cout << res[i][j] << ",";
        }
        cout << "" << endl;
    }
    return 0;
}
```
