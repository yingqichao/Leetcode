/**
 * @author Qichao Ying
 * @date 2019/9/2 16:22
 * @Description DEFAULT
 */
import java.util.*;
public class largestInHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1,1}));
    }

    public static int largestRectangleArea(int[] heights) {
        //每次寻找当前为最高时候的左右能到哪里，也就是左右第一个比当前小的index
        int[] left = previousLess(heights);int[] right = nextLess(heights);
        int max = 0;
        for(int i=0;i<heights.length;i++){
            int r = (right[i]==-1)?heights.length-1:right[i]-1;
            int l = (left[i]==-1)?0:left[i]+1;
            max = Math.max(heights[i]*(r-l+1),max);
        }
        return max;
    }

    public static int[] previousLess(int[] A){
        //Given  [3 7 8 4]
        //Output [-1 3 7 3] (convert to indices->-1 0 1 0)
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[A.length];
        for(int i=0;i<A.length;i++){
            while(stack.size()!=0 && A[stack.peek()]>=A[i]){
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
            while(stack.size()!=0 && A[stack.peek()]>=A[i]){
                stack.pop();
            }
            res[i] = (stack.size()==0)?-1:stack.peek();
            stack.push(i);
        }

        return res;

    }
}
