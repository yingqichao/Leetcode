package niuke;

import java.util.Scanner;

/**
 * @author Qichao Ying
 * @date 2019/8/20 19:40
 * @Description DEFAULT
 */
public class BigIntegerMultiply {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        String t = in.nextLine();
//        System.out.println(two(s,t));
//    }
//
//    public static void main(String[] args) {
//        System.out.println(two("2","3"));
//    }

    public static String two(String s1,String s2){

        int[] num1 = new int[s1.length()];int[] num2 = new int[s2.length()];

        for(int i=0;i<num1.length;i++)    num1[i] = s1.charAt(i)-'0';
        for(int i=0;i<num2.length;i++)    num2[i] = s2.charAt(i)-'0';

        int[] result = new int[num1.length + num2.length];

        for (int i = 0; i < num1.length; i++){
            for (int j = 0; j < num2.length; j++){
                result[i + j + 1] += num1[i] * num2[j];
            }
        }

        for(int k = result.length-1; k > 0; k--){
            if(result[k] > 10){
                result[k - 1] += result[k] / 10;
                result[k] %= 10;
            }
        }

        StringBuilder str = new StringBuilder();boolean init = true;
        for(int in:result){
            if(in==0 && init) continue;
            else{
            str.append(in);
            init = false;
            }
        }
        return str.toString();
    }
}
