/**
 * @author Qichao Ying
 * @date 2019/9/4 19:06
 * @Description DEFAULT
 */
import java.util.*;
public class huawei_1 {

//    public static void main(String[] args) {
//        List<Integer> list = new LinkedList<>();
//        list.add(1035);list.add(0);list.add(10);
//        one(list);
//
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();
        while(in.hasNextLine()){
            list.add(Integer.parseInt(in.nextLine()));
        }
        one(list);
    }

    public static void one(List<Integer> list){
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int sum = 0;
        for(int i=0;i<=100;i++){
            sum+=i;
            map.put(sum,i);
        }
        for(int in:list){
            if(map.containsKey(in))    System.out.println(map.get(in));
            else System.out.println("No");
        }
    }


    public static void three(ListNode root,int K){
        ListNode fakeHead = new ListNode(0);fakeHead.next = root;
        ListNode back = root;ListNode front = back;ListNode prev = fakeHead;int count = 0;
        while(front!=null){
            if(count!=K-1){
                front = front.next;
                count++;
            }else{
                ListNode tmp = front.next;front.next = null;
                reverseList(back);
                prev.next = front;prev = back;
                front = tmp;back = tmp;
                count = 0;
            }


        }

        prev.next = back;

//        return fakeHead.next;
        ListNode node = fakeHead.next;
        while(node!=null){
            System.out.print(node.val);
            node = node.next;
            if(node!=null)  System.out.print("->");
        }

    }

    static class ListNode {
      int val;
      ListNode next = null;
      ListNode(int x) { val = x; }
    }


    public static ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)   return head;
        ListNode pre = head;ListNode cur = head.next;
        pre.next = null;
        while(cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;

    }


    public static int two(String str){
        String[] s = str.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int date = Integer.parseInt(s[2]);
        int res = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            if (year%4==0 && i == 1) {
                res += days[i] + 1;
                continue;
            }
            res += days[i];
        }
        return res + date;
    }

    public static String one(String a1, String b1) {
        String[] A = a1.split("\\+");
        String[] B = b1.split("\\+");
        int a = Integer.parseInt(A[0]);
        int b = (A[1].length()==1)?1:Integer.parseInt(A[1].substring(0, A[1].length() - 1));
        int c = Integer.parseInt(B[0]);
        int d = (B[1].length()==1)?1:Integer.parseInt(B[1].substring(0, B[1].length() - 1));

        int r = (a * c) - (b * d);
        int i = (a * d) + (b * c);
        return r + "+" + i + "i";

    }

//    public static int two(int num){
//        int sum = num;int begin = 0;int round =0;
//        while(sum>0){
//            int eli = (sum+begin)/5;
//            begin = (sum+begin)%5;
//            round+=eli;
//            if(begin==0)    return round;
//
//
//            sum = sum -eli;
//        }
//
//        return round;
//
//
//    }



//        public double largestTriangleArea(int[][] p) {
//            double res = 0;
//
//            for (int[] i: p)
//                for (int[] j: p)
//                    for (int[] k: p)
//                        res = Math.max(res,
//            return res;
//        }



//    public static List<Integer> one(int numOfItems,Stock[] StockDetails,
//                             int numOfQueries,List<List<Integer>> queries){
//        List<Integer> res = new LinkedList<>();
//
//        Map<Integer,Integer>  qualityMap = new HashMap<>();
//        Map<Integer,Integer>  quantityMap = new HashMap<>();
//        for(Stock stock:StockDetails){
//            qualityMap.put(stock.itemId,stock.quality);
//            quantityMap.put(stock.itemId,stock.quantity);
//        }
//        for(List<Integer> list:queries){
//            int order = list.get(0);
//            if(order==1){
//                //买进
//                int id = list.get(1);
//                int quality = list.get(2);
//                int quantity = list.get(3);
//                if(qualityMap.containsKey(id) && qualityMap.get(id)<=quality){
//                    quantityMap.put(id,quantityMap.get(id)+quantity);
//                }
//            }
//            else if(order==2){
//                //卖出
//                int id = list.get(1);
//                int quantity = list.get(2);
//
//                quantityMap.put(id,Math.max(0,quantityMap.get(id)-quantity));
//
//            }else if(order==3){
//                //查询
//                int start = list.get(1);
//                int end = list.get(2);
//                int sum = 0;
//                for(int i=start;i<=end;i++)
//                    sum+=quantityMap.getOrDefault(i,0);
//                res.add(sum);
//            }
//        }
//        return res;
//    }

    public List<String> ans(int numWords,String[] words,int numQuestion,int[] question){
        List<String> res = new LinkedList<>();

        TreeMap<String,Integer> preorder = new TreeMap<>();
        TreeMap<String,Integer> suborder = new TreeMap<>();
        for(String word:words){
            preorder.put(word,preorder.getOrDefault(word,0)+1);
            String str = new StringBuilder(word).reverse().toString();
            suborder.put(str,preorder.getOrDefault(str,0)+1);
        }

        for(int in:question){
            if(in==1){
                res.add(preorder.lastKey());
            }else if(in==2){
                res.add(preorder.firstKey());
            }else if(in==3){
                int num = preorder.get(preorder.firstKey());
                if(num==1)  res.add(preorder.higherKey(preorder.firstKey()));
                else    res.add(preorder.firstKey());

            }else if(in==4){
                int num = preorder.get(preorder.lastKey());
                if(num==1)  res.add(preorder.lowerKey(preorder.lastKey()));
                else    res.add(preorder.lastKey());
            }else if(in==5){
                String str = suborder.firstKey();
                String newStr = new StringBuilder(str).reverse().toString();
                res.add(str);
                //update
                int num = suborder.get(str);

                suborder.put(str,suborder.get(str)-1);
                preorder.put(newStr,preorder.get(newStr)-1);

                suborder.put(newStr,suborder.getOrDefault(newStr,0)+1);
                preorder.put(str,preorder.getOrDefault(str,0)+1);

            }
        }

        return res;
    }


    public static int one(int a,int b,int c,int k){
        int res = 1;
        int aget = 1;int bget = 1;int cget = 1;
        while(k>0 && (aget!=Integer.MAX_VALUE || bget!=Integer.MAX_VALUE || cget!=Integer.MAX_VALUE)){
            int min = Math.min(aget,Math.min(bget,cget));
            res = res*(min+1)/min;
            if(min==aget)   {aget++;if(aget==a) aget = Integer.MAX_VALUE;}
            else if(min==bget)   {bget++;if(bget==b) bget = Integer.MAX_VALUE;}
            else {cget++;if(cget==c) cget = Integer.MAX_VALUE;}
            k--;
        }

        return res;
    }

    public static long count = 0;
    public static int mod = (int)Math.pow(10,9)+7;

    public static int nums(int[] list){
        boolean[] used = new boolean[list.length+1];
        for(int i=0;i<used.length;i++) {
            List<Integer> debug = new LinkedList<>();debug.add(i);
            used[i] = true;
            dfs(used, 1, i, list, debug);
            used[i] = false;
            debug.remove(debug.size()-1);
        }

        return (int)count;

    }

    public static void dfs(boolean[] used,int had,int last,int[] list,List<Integer> debug){
        //pre
        if(had==used.length){
            count++;
            count %= mod;
            for(int in:debug)   System.out.print(in+" ");

            System.out.println();
            return;
        }
        int index = had-1;
        int begin;int end;
        if(list[index]==1){begin = 0;end = last;}//ascend
        else{begin = last+1;end = used.length;}//descend
        for(int i=begin;i<end;i++){
            if(!used[i]) {
                used[i] = true;
                debug.add(i);
                dfs(used,had+1,i,list,debug);
                debug.remove(debug.size()-1);
                used[i] = false;
            }
        }
    }

    public static String two(String[] lines){
        Map<String,Long> map = new HashMap<>();String variable = "";
        for(int i=0;i<lines.length;i++){
            String[] str = lines[i].split("=");
            if(str.length<2)    continue;
            variable = str[0].trim();
            //calculate
            String right = str[1];
            long ans = 0;
            String[] vars = right.split("\\+");
            for(String var:vars){
                var = var.trim();
                long curr;
                try{
                    curr = Long.parseLong(var);
                }catch(Exception e){
                    if(!map.containsKey(var))   return "NA";
                    curr = map.get(var);
                }
                ans+=curr;
                if(ans>Integer.MAX_VALUE)     return "NA";
            }
            map.put(variable,map.getOrDefault(variable,(long)0)+ans);
        }

        return map.get(variable).toString();
    }

}
