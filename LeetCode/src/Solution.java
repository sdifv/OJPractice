import java.util.ArrayList;
import java.util.Iterator;
import structure.ListNode;
import structure.TreeNode;

public class Solution {

  public static void main(String[] args) {
      Solution s = new Solution();
      s.testPrintListFromTailToHead();
  }

  public boolean Find(int target, int[][] array) {
    int r = array.length;
    int c = array[0].length;
    System.out.printf("r=%d,c=%d%n",r,c);

    if (c == 0){  //数组为空
      return false;
    }
    else if(array[0][0] > target | array[r-1][c-1] < target) {  //target越界
      return false;
    }

    for (int i = 0; i < r; i++) {   //找出r的上界
      if(array[i][0]>target){
        r = i;
        break;
      }
    }

    for(int j = 0; j < c; j++){   //找出c的上界
      if(array[0][j]>target){
        c = j;
        break;
      }
    }

    for(int i=r-1; i>=0; i--){   //在缩小的范围内反向遍历,加速查找
      for(int j=c-1; j>=0; j--){
        if(array[i][j] == target){
          return true;
        }
      }
    }
    return false;
  }

  public void testFind() {
    int[][] array1 = {{1,2,8,9},{4,7,10,13}};
    int[][] array2 = {{}};
    int target = 7;
    if(Find(target,array2)){
      System.out.println("Right!");
    }
    else{
      System.out.println("Wrong!");
    }
  }

  public String replaceSpace(StringBuffer str) {
    String s = str.toString();
    String res = s.replace(" ","%20");
    return res;
  }

  public void testReplaceSpace(){
    StringBuffer str = new StringBuffer("we are happy !");
    System.out.println(replaceSpace(str));
  }

  public String deleteChars(String s1, String s2){
    StringBuffer res = new StringBuffer();
    for(int i=0;i<s1.length();i++){
      if(s2.indexOf(s1.charAt(i))==-1){
        res.append(s1.charAt(i));
      }
    }
    return res.toString();
  }

  public void testDeleteChars(){
    String s1 = "They are students.";
    String s2 = "aeiou";
    System.out.println(deleteChars(s1,s2));
  }

  public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

    ArrayList<Integer> res = new ArrayList<>();

    if(listNode == null){
      return res;
    }

    ListNode pre = null;
    ListNode next = null;

    while(listNode!=null){
      next = listNode.next;
      listNode.next = pre;
      pre = listNode;
      listNode = next;
    }

    while(pre!=null){
      res.add(pre.val);
      pre = pre.next;
    }

    return res;
  }

  public void testPrintListFromTailToHead(){
    ListNode testList = new ListNode(0);
    testList.afterInsert(1);

    ArrayList<Integer> res = printListFromTailToHead(testList);
    Iterator<Integer> it = res.iterator();
    while(it.hasNext()){
      System.out.println(it.next());
    }

//    while(testList!=null){
//      System.out.print(testList.val);
//      testList = testList.next;
//    }

  }

  public void Mirror(TreeNode root) {
    if(root == null){
      return;
    }
    if(root.left == null){
      root.left = root.right;
      root.right = null;
      Mirror(root.left);
    }
    else if(root.right == null){
      root.right = root.left;
      root.left = null;
      Mirror(root.right);
    }
    else{
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      Mirror(root.right);
      Mirror(root.left);
    }
  }

}


