package solutions;

public class Solution {

  public static void main(String[] args) {
      Solution s = new Solution();
      s.testDeleteChars();
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

}


