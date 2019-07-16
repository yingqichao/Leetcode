import java.util.Scanner;

public class IsSubsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S1 = in.nextLine();
    }




    public boolean isSubsequence(String s, String t) {
        if(s.length()>t.length())   return false;
        int s1 = 0;int s2 = 0;
        while(s1<s.length() && s2<t.length()){
            if(s.charAt(s1)==t.charAt(s2)){
                s1++;
            }
            s2++;
        }

        return s1 == s.length();



    }
}


