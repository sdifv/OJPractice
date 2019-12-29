import javax.sound.midi.Soundbank;
/*
 * Q:请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy
 * tag: 字符串
 */
public class Solution2 {
  public String replaceSpace(StringBuffer str) {
    String s = str.toString();
    String res = s.replace(" ","%20");
    return res;
  }

  public void testReplaceSpace(){
    StringBuffer str = new StringBuffer("we are happy !");
    System.out.println(replaceSpace(str));
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    s.testReplaceSpace();
  }
}
