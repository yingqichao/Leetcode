package Tree;

import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        System.out.print(evalRPN("2 1 + 3 *"));
    }
    public static int evalRPN(String token) {
        String [] tokens = token.split(" ");
        Stack<Integer> stack = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int a = stack.pop();int b=stack.pop();
                if(s.equals("+"))
                    stack.push(b+a);
                else if(s.equals("-"))
                    stack.push(b-a);
                else if(s.equals("*"))
                    stack.push(b*a);
                else
                    stack.push(b/a);
            }else
                stack.push(Integer.parseInt(s));
        }

        return stack.pop();
    }
}