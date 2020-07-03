//给出一个区间的集合，请合并所有重叠的区间。 
//
// 示例 1: 
//
// 输入: [[1,3],[2,6],[8,10],[15,18]]
//输出: [[1,6],[8,10],[15,18]]
//解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2: 
//
// 输入: [[1,4],[4,5]]
//输出: [[1,5]]
//解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
// Related Topics 排序 数组


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }

        // 按数组的首位数值，从小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ansList = new ArrayList<>();

        int[] arr1 = intervals[0];
        int upper = arr1[arr1.length-1];
        int lower = arr1[0];
        for (int i=0; i<intervals.length;i++){
            int[] arr = intervals[i];
            if(arr[0]>upper){   // 当前数组的下界大于维护的上界，生成新的区间
                ansList.add(new int[]{lower,upper});
                lower = arr[0];
                upper = arr[arr.length-1];
            }else if(arr[arr.length-1]>upper){  // 当前数组的上界大于维护的上界，生成新的上界
                upper = arr[arr.length-1];
            }
        }
        //  最后一组区间
        ansList.add(new int[]{lower, upper});

        return ansList.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
