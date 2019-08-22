import java.util.*;

public class Test {

    public static void main(String[] args) {
        String str = "2+1*3-5";
        String[] strs = str.split("[\\\\+\\-\\\\*]");
        List<Integer> list = diffWaysToCompute(str);
        System.out.println();

    }

    public static char[] symbols;
    public static int[] dig;
    public static Map<Integer,List<Integer>> map = new HashMap<>();



    public static List<Integer> diffWaysToCompute(String input) {
        String str = input.replace("[\\\\+\\-\\\\*]","");
        symbols = str.toCharArray();
        String[] digits = input.split("[\\\\+\\-\\\\*]");
        dig = new int[digits.length];
        for(int i=0;i<digits.length;i++)    dig[i] = Integer.parseInt(digits[i]);

        return dp(0,dig.length);

    }

    public static List<Integer> dp(int left,int right){
        if(map.containsKey(left*dig.length+right))
            return map.get(left*dig.length+right);
        List<Integer> res = new LinkedList<>();
        if(left+1==right)   {res.add(dig[left]);return res;}
        for(int i=left+1;i<right;i++){
            List<Integer> leftCalc = dp(left,i);
            List<Integer> rightCalc = dp(i,right);
            for(int lC:leftCalc){
                for(int rC:rightCalc){
                    if(symbols[i-1]=='+')   res.add(lC+rC);
                    if(symbols[i-1]=='-')   res.add(lC-rC);
                    if(symbols[i-1]=='*')   res.add(lC*rC);
                }
            }
        }

        map.put(left*dig.length+right,res);
        return res;
    }

}
