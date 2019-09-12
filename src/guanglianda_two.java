

/**
 * @author Qichao Ying
 * @date 2019/8/26 19:22
 * @Description DEFAULT
 */
import java.util.*;
public class guanglianda_two {

    public static void main(String[] args) {
//        List<String> list = ambiguousCoordinates("(00011)");
//        for(String str:list)
//            System.out.println(str);
        System.out.println(longestWPI(new int[]{6,6,9}));
    }

    static int interval = 8;
    public static int longestWPI(int[] hours) {
        TreeMap<Integer,Integer> leftmost = new TreeMap<>();
        int net = 0;int ans = 0;
        for(int i=0;i<hours.length;i++){
            int in = hours[i];
            if(in>interval){ net++;if(ans==0)   ans=1;}
            else net--;
            if(net==1)  ans = i+1;

            if(!leftmost.containsKey(net))  leftmost.put(net,i);
            int key = net-1;
            while(leftmost.lowerKey(key)!=null){
                int left = leftmost.get(leftmost.lowerKey(key));
                ans = Math.max(ans,i-left+1);
                key = leftmost.lowerKey(key);
            }


        }

        return ans;
    }

    public static List<String> ambiguousCoordinates(String S) {
        List<String> list = new LinkedList<>();
        String str = S.substring(1,S.length()-1);
        for(int mid=1;mid<=str.length()-1;mid++){
            List<String> first = checkvalid(str,0,mid);
            List<String> last = checkvalid(str,mid,str.length());
            for(int i=0;i<first.size();i++){
                for(int j=0;j<last.size();j++){
                    list.add("("+first.get(i)+", "+last.get(j)+")");
                }
            }
        }

        return list;

    }

    public static List<String> checkvalid(String str,int begin,int end){
        List<String> list = new LinkedList<>();
        String string = str.substring(begin,end);
        if(string.equals("0"))
            list.add(string);
        else if(str.charAt(end-1)=='0') {
            if (str.charAt(begin) != '0')
                list.add(string);
        }

        else if(str.charAt(begin)=='0')
            list.add("0."+string.substring(1));
        else{
            for(int mid=1;mid<=string.length();mid++){
                list.add(string.substring(0,mid)+((mid==string.length())?"":".")+string.substring(mid));
            }
        }

        return list;

    }
}
