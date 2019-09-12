package Stack;

import java.util.Stack;

/**
 * @author Qichao Ying
 * @date 2019/8/28 12:43
 * @Description DEFAULT
 */
public class SumOfSubarrayMinimum907 {
    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3,1,2,4}));
    }

    static int mod = (int)Math.pow(10,9)+7;

    public static int sumSubarrayMins(int[] A) {
        int[] prevLess = previousLess(A);
        int[] nextLess = nextLess(A);

        int ans = 0;
        for(int i = 0; i < A.length; i++){
            ans = (ans + A[i]*prevLess[i]*nextLess[i])%mod;
        }
        return ans;

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
            res[i] = (stack.size()==0)?1:i-stack.peek()+1;
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
            res[i] = (stack.size()==0)?1:stack.peek()-i+1;
            stack.push(i);
        }

        return res;

    }
}
