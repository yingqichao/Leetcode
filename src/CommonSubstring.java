/**
 * @author Qichao Ying
 * @date 2019/8/8 20:46
 * @Description DEFAULT
 */
public class CommonSubstring {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }

    public static int[][] memo;

    public static int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];

        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                if(i>0 && text2.charAt(j)==text1.charAt(i-1))
                    memo[i][j] = Math.max(memo[i][j],memo[i-1][j]+1);
                else
                    memo[i][j] = (i==0)?0:Math.max(memo[i][j],memo[i-1][j]);
                if(j>0 && text1.charAt(i)==text2.charAt(j-1))
                    memo[i][j] = Math.max(memo[i][j],memo[i][j-1]+1);
                else
                    memo[i][j] = (j==0)?0:Math.max(memo[i][j],memo[i][j-1]);
            }
        }

        return memo[text1.length()-1][text2.length()-1];

    }
}
