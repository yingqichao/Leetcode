import java.util.LinkedList;
import java.util.List;

/**
 * @author Qichao Ying
 * @date 2019/8/22 10:26
 * @Description DEFAULT
 */
public class FibonacciBreak {
    public static void main(String[] args) {

        splitIntoFibonacci( "11235813");
        for(int in:list)
        System.out.println(in);
    }

    static List<Integer> list = new LinkedList<>();
    public static List<Integer> splitIntoFibonacci(String S) {
        backtrack(-1,-1,0,S,new LinkedList<>(),0,0);

        return list;
    }

    public static void backtrack(int prev2,int prev,int index,String s,List<Integer> got,int validLen,int num){
        if(validLen==s.length() && prev2!=-1 && prev!=-1 && num>=3){
            list = new LinkedList<>(got);return;
        }
        if(list.size()!=0 || index>=s.length())  return;
        int curr = 0;
        for(int end=index+1;end<=s.length();end++){
            curr = Integer.parseInt(s.substring(index,end));
            if(prev2==-1) {
                //第一个值没有
                got.add(curr);validLen+=end-index;num+=1;
                backtrack(curr,prev,end,s,got,validLen,num);
                if(list.size()!=0)  return;
                got.remove(got.size()-1);validLen-=end-index;num-=1;
            }else if(prev==-1) {
                //第二个值没有
                got.add(curr);validLen+=end-index;num+=1;
                backtrack(prev2,curr,end,s,got,validLen,num);
                if(list.size()!=0)  return;
                got.remove(got.size()-1);validLen-=end-index;num-=1;
            }else{
                if(curr>prev2+prev) return;
                else if(curr==prev2+prev){
                    prev2 = prev;prev = curr;
                    got.add(curr);validLen+=end-index;num+=1;
                    backtrack(prev2,prev,end,s,got,validLen,num);
                    if(list.size()!=0)  return;
                    got.remove(got.size()-1);validLen-=end-index;num-=1;
                }
            }
        }


    }
}
