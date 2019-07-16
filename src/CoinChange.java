import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoinChange {

    public static int[] memo;

    public static void main(String[] args) {
        int[] list = new int[]{1,2,5};
        System.out.println(coinChange(list,100));



    }

    public static int slowCoinChange(int[] coins, int amount) {
        //bfs
        Queue<Integer> front = new LinkedList<>();Queue<Integer> back = new LinkedList<>();
        back.offer(amount);int round = 0;
        while(back.size()!=0){
            front = back;back = new LinkedList<>();round++;
            boolean changed = false;
            while(front.size()!=0){
                int curr = front.poll();
                for(int coin:coins){
                    if(curr==coin)  return round;
                    if(curr>coin){
                        changed = true;
                        back.offer(curr-coin);
                    }
                }
            }
            if(!changed)    return -1;
        }

        return -1;

    }

    public static int coinChange(int[] coins, int amount) {
        memo = new int[amount];
        //sort
        Arrays.sort(coins);
        int res = bt(coins,amount,coins.length-1);
        return (res>=0)?res:-1;

    }

    public static int bt(int[] coins,int rest,int index){
        //preliminary
        if(rest==0)  return 0;
        if(index==0)    return (((double)rest/coins[0])==rest/coins[0]?rest/coins[0]:Integer.MIN_VALUE);

        int max = rest/coins[index];int min = Integer.MAX_VALUE;
        for(int i=max;i>=0;i--){
            int curr = bt(coins,rest-i*coins[index],index-1);
            if(curr>=0) min = Math.min(min,i+curr);
        }


        return (min>=0)?min:Integer.MIN_VALUE;
    }
}
