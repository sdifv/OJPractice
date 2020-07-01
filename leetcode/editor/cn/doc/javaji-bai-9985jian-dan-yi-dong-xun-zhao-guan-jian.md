### 解题思路
从题意里看，能够卡住跳到最后的关键数字就是0
如果数组中的不存在0，那么肯定可以跳到最后
因此，我们只要找出数组中的数字0
然后在判断这些0我们能否跳过去就行了

### 代码

```java
class Solution {
    public boolean canJump(int[] nums) {
        if (nums[0] == 0 && nums.length > 1) {
            return false;
        }//特判，数组第一个元素为0且数组元素大于一个的时候，必定不能到达
        int count1 = 0;//未跳过的0的数量
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                count1++;//遇到0，未跳过的0计数+1
                for (int j = 0; j < i; j++) {
                    if (nums[j] >= i - j + 1) {
                        count1--;//如果遇到的这个0前面有数字可以跳过它，那么未跳过的0计数-1
                        break;//跳过之后就去寻找下一个0
                    } 

                }
            }
        }
        if(count1 == 0){
            return true;//如果所有的0都能跳过，那么未跳过的0计数为0，返回true
        }else{
            return false;
        }
        
    }
}
```