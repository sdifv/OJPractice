package solutions;
/*
 * Q: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * tag: 栈，树
 */
public class Solution23 {
  public boolean VerifySquenceOfBST(int [] sequence) {
    if(sequence==null||sequence.length==0){
      return false;
    }
    return checkSquenceOfBST(0,sequence.length-1,sequence);
  }

  public boolean checkSquenceOfBST(int left,int right,int[] sequence){
    if(left>=right){
      return true;
    }
    int mid = sequence[right];
    int i;
    for(i=left;i<right;i++){
      if(sequence[i]>mid){
        break;
      }
    }

    for(int j=i;j<right;j++){
      if(sequence[j]<mid){
        return false;
      }
    }
    //检查右子树时不包含sequence最后一个元素（根节点）
    return checkSquenceOfBST(left,i-1,sequence)&&checkSquenceOfBST(i,right-1,sequence);
  }
}
