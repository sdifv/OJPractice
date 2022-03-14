package algorithm;

public class InterLeave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() == 0)
            return s2.equals(s3);
        if(s2.length() == 0)
            return s1.equals(s3);
        if(s1.length() + s2.length() != s3.length())
            return false;
        boolean[] used = new boolean[s3.length()];
        int i = 0, j = 0;
        while(i < s1.length() && j < s3.length()){
            if(s1.charAt(i) == s3.charAt(j)){
                used[j] = true;
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i < s1.length()) return false;
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < used.length; k++){
            if(!used[k]){
                sb.append(s3.charAt(k));
            }
        }
        return sb.toString().equals(s2);
    }

    public static void main(String[] args) {
        InterLeave il = new InterLeave();
        System.out.println(il.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}
