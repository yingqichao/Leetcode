//package meituan;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.Stack;
//
///**
// * @author Qichao Ying
// * @date 2019/8/22 11:09
// * @Description DEFAULT
// */
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        int in = Integer.parseInt(s);
//        System.out.println(one(s));
//    }
//
//
//    public static String one(int n) {
//        return ((int)Math.pow(2,n)-1)+"/"+((int)Math.pow(2,n-1));
//
//    }
//
//
//    public static int one(String string) {
//        string = string.substring(1,string.length()-1);
//        List<List<Character>> list = new LinkedList<>();
//        int start = 0;String curr = string;
//        while(curr.indexOf("}")>=0){
//            List<Character> temp = new LinkedList<>();
//            int index = curr.indexOf("}");
//            String curr1 = curr.substring(1,index-1);
//            String[] strs = curr1.split(",");
//            for(String str:strs){
//                temp.add(str.charAt(1));
//            }
//            list.add(temp);
//            start = index+2;
//            if(start>=curr.length())    break;
//            curr = curr.substring(start);
//        }
//
//        char[][] matrix = new char[list.size()][list.get(0).size()];
//        for(int i=0;i<matrix.length;i++){
//            List<Character> temp = list.get(i);
//            for(int j=0;j<matrix[0].length;j++){
//                matrix[i][j] = temp.get(j);
//            }
//        }
//
//        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
//
//        int[] height = new int[matrix[0].length];
//        for(int i = 0; i < matrix[0].length; i ++){
//            if(matrix[0][i] == '1') height[i] = 1;
//        }
//        int result = findLarge(height);
//        for(int i = 1; i < matrix.length; i ++){
//            findHeight(matrix, height, i);
//            result = Math.max(result, findLarge(height));
//        }
//
//        return result;
//    }
//
//    private static void findHeight(char[][] matrix, int[] height, int idx){
//        for(int i = 0; i < matrix[0].length; i ++){
//            if(matrix[idx][i] == '1') height[i] += 1;
//            else height[i] = 0;
//        }
//    }
//
//    public static int findLarge(int[] height) {
//        if(height == null || height.length == 0) return 0;
//        Stack<Integer> stack = new Stack<>();
//        int maxArea = 0;
//        for(int i = 0; i <= height.length; i++){
//            int h = (i == height.length ? 0 : height[i]);
//            if(stack.isEmpty() || h >= height[stack.peek()])    stack.push(i);
//            else{
//                int top = stack.pop();
//                maxArea = Math.max(maxArea, height[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
//                i--;
//            }
//        }
//        return maxArea;
//    }
//}
