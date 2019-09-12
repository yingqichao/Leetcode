import java.util.*;

/**
 * @author Qichao Ying
 * @date 2019/8/28 22:17
 * @Description DEFAULT
 */
public class findPair {
    static int sum = 0;
    public static void main(String[] args) {
//        int[][] area = {{1,2,3,5,7,6},{2,1,4,5,7,4},{3,4,5,6,3,6},{2,3,1,4,6,8},{5,6,1,4,6,2},{4,2,4,1,1,6}};
//        int[][] area2 = {{1,1},{2,3}};
//        int [][] area1 ={{35,92,98,68,35,65,26,72},{29,78,83,16,5,89,92,28},{48,51,37,79,65,74,50,71},{98,78,99,57,1,30,22,16},{72,88,55,33,56,58,28,49},{4,28,29,20,18,61,11,73},{61,19,47,34,85,32,77,89},{29,49,10,81,52,5,63,25}};
//        System.out.println(getMinimumTimeCost(2,area2));

//        System.out.println(two(new int[][]{new int[]{1,1},new int[]{2,2}}));
        System.out.println(three(10,new int[]{1,2,3,4}));
//        five(2,new int[][]{new int[]{1,3},new int[]{2,3},new int[]{4,4}});
    }

//    public static void five(int k,int[][] in){
//        int mod = (int)Math.pow(10,9)+7;
//        int max = 0;
//        for(int[] list:in)  max = Math.max(max,list[1]);
//        long[] dp = new long[max+1];
//        dp[0] = 1;
//
//        for(int i=0;i<max+1;i++){
//            for(int j=k;j<=i;j+=k){
//                dp[i]+=(dp[i-j]*j);
//            }
//            dp[i] = dp[i]%mod;
//            if(dp[i]==0)    dp[i] = 1;
//        }
//
//
//        //output
//        for(int[] range:in){
//            long sum = 0;
//            if(k!=0) {
//                for(int i=range[0];i<=range[1];i++){
//                    sum+=dp[i];
//                    sum = sum%mod;
//                }
//
//
//            }
//
//
//
//            System.out.println((int)sum);
//        }
//    }

    public static int three(int workers,int[] room){
        int lastIndex = room.length-1;
        for(;lastIndex>=0;lastIndex--)
            if(room[lastIndex]!=0)  break;

        Stack<Integer> stack = new Stack<>();stack.push(workers);int time = 0;
        for(int i=0;i<room.length;i++){
            if(room[i]!=0){
                int remain = room[i];
                while(remain!=0) {
                    int num = stack.pop();
//                    if(num==0){time++;continue;}
    //                if(num>=remain){
                    if(num!=0) {
                        int first = Math.min(remain, num);
                        int second = num - first;
                        remain -= first;
                        int newfirst = (stack.size() == 0) ? first : first + stack.pop();
//                    if (stack.size() != 0) {
//                        stack.push(first + stack.pop());
//                    } else stack.push(first);

                        stack.push(newfirst);
                        if(second!=0)   stack.push(second);
                        if (0 == remain) {
                            if(second==0 && i!=lastIndex)   time++;
                            break;
                        }
                    }
                    time++;
    //                }else{
    //                    stack
    //                }

                }
            }
            time++;


        }
        return time+1-(room.length-1-lastIndex);

    }

    public static int two(int[][] in) {
        int n = in.length;
        long ans = 0;
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < n; i++) {
            queue.offer(in[i][0] - in[i][1]);
            ans += in[i][1] * (n - 1);
        }

        for (int i = 0; i < n; i++)
                ans += queue.poll() * i;

            return (int) ans;

    }



}
