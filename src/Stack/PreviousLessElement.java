package Stack;

import java.util.Stack;

/**
 * @author Qichao Ying
 * @date 2019/8/28 12:13
 * @Description DEFAULT
 */
public class PreviousLessElement {
    public static void main(String[] args) {
        int[] nextLess = previousLess(new int[]{3,7,8,4});
        for(int in:nextLess)    System.out.println(in);
    }

    public static int[] previousLess(int[] A){
        //Given  [3 7 8 4]
        //Output [-1 3 7 3] (convert to indices)
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i=0;i<A.length;i++){
            while(stack.size()!=0 && A[stack.peek()]>A[i]){
                stack.pop();
            }
            res[i] = (stack.size()==0)?-1:stack.peek();
            stack.push(i);
        }

        return res;

    }

    public static int[] nextLess(int[] A){
        //Given  [3 7 8 4]
        //Output [-1 4 4 -1] (convert to indices)
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i=A.length-1;i>=0;i--){
            while(stack.size()!=0 && A[stack.peek()]>A[i]){
                stack.pop();
            }
            res[i] = (stack.size()==0)?-1:stack.peek();
            stack.push(i);
        }

        return res;

    }
}
