import LRUCache.LRU;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Huawei {

    public static void main(String[] args) {

            System.out.println(simplifyPath("/../"));



    }

    public static String simplifyPath(String path) {
        List<String> list = new LinkedList<>();
        String[] strs = path.split("/");
        for(String str:strs){
            if(!str.equals("") && !str.equals(".")){
                if(str.equals(".."))
                    if(list.size()>0)
                        list.remove(list.size()-1);
                    else
                        list.add(str);
            }
        }

        StringBuilder res = new StringBuilder();
        for(String s:list)  {res.append("/");res.append(s);}

        return res.toString();
    }

    public static String[] One(String[] in){
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(String s:in){
            int len = s.length();int start=0;
            while(start<len){
                String temp;
                if(len-start>=8) temp = s.substring(start,start+8);
                else{
                    temp = s.substring(start,len);
                    for(int i=0;i<8-(len-start);i++)
                        temp = temp+'0';
                }
                pq.offer(temp);
                start+=8;
            }

        }
        int total = pq.size();
        String[] out = new String[total];
        for(int i=0;i<total;i++)
            out[i] = pq.poll();
        return out;
    }





    public static int Three(int[][] in,int startrow,int startcol,int endrow,int endcol){
        int[][] memo = new int[in.length][in[0].length];int[][] newmemo = new int[in.length][in[0].length];
        memo[startrow][startcol] = 1;int revise = 0;boolean start = true;
        while(start || revise!=0) {
            start = false;
            revise = 0;
            for (int i = 0; i < in.length; i++) {
                for (int j = 0; j < in[0].length; j++) {
                    if (memo[i][j] != 0) {
                        if (i != 0 && in[i - 1][j] > in[i][j]) {newmemo[i - 1][j] += memo[i][j];revise++;}
                        if (i != in.length - 1 && in[i + 1][j] > in[i][j]) {newmemo[i + 1][j] += memo[i][j];revise++;}
                        if (j != 0 && in[i][j - 1] > in[i][j]) {newmemo[i][j - 1] += memo[i][j];revise++;}
                        if (j != in[0].length - 1 && in[i][j + 1] > in[i][j]) {newmemo[i][j + 1] += memo[i][j];revise++;}
                    }
                }
            }

            if(revise!=0)   memo = newmemo;
        }

        return in[endrow][endcol];


    }

    public static String Two(String in){
        return func(in).reverse().toString();
    }

    public static StringBuilder func(String in){
        StringBuilder str = new StringBuilder();
        for(int i=0;i<in.length();i++){
            if(in.charAt(i)=='(' || in.charAt(i)=='[' || in.charAt(i)=='{' || (in.charAt(i)>='0' && in.charAt(i)<='9'))
            {

                int j = i;
                while(in.charAt(j)>='0' && in.charAt(j)<='9'){
                    j++;
                }

                char right = ')';
                if(in.charAt(j)=='[')   right = ']';
                else if(in.charAt(j)=='{')   right = '}';
                int times = (j==i)?1:Integer.parseInt(in.substring(i,j));
                j++;
                int start = j;
                j=in.length()-1;
                while(in.charAt(j)!=right){
                    j--;
                }
                StringBuilder strin = func(in.substring(start,j));
                for(int t=0;t<times;t++)
                    str.append(strin);

                i=j;
            }else   str.append(in.charAt(i));

        }
        return str;
    }


}
