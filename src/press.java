import java.util.*;
public class press {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String t = in.nextLine();
//        String s = in.nextLine();
//        System.out.println(one(s));
//    }
public static void main(String[] args) {
    System.out.println(one("AaAAAAa"));
}

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] group = new int[N];
        Arrays.fill(group,-1);
        Map<Integer,Set<Integer>> map = new HashMap<>();
        for(int[] dislike:dislikes){
            Set<Integer> set1 = map.getOrDefault(dislike[0]-1,new HashSet<>());
            Set<Integer> set2 = map.getOrDefault(dislike[1]-1,new HashSet<>());
            set1.add(dislike[1]-1);set2.add(dislike[0]-1);
            map.put(dislike[0]-1,set1);map.put(dislike[1]-1,set2);
        }

        for(int i=0;i<N;i++){
            if(group[i]==-1){
                assign(i,map,group,0);
//                if(!assign(i,map,group,0))    return false;
            }
        }

        return true;
    }

    public boolean assign(int person,Map<Integer,Set<Integer>> map,int[] group,int loc){
        if(group[person]!=-1)   return group[person]==loc;

        int newLoc = (loc==0)?1:0;
        group[person] = loc;
        if(map.containsKey(person)){
            Set<Integer> set = map.get(person);
            for(int dislike:set){
                assign(dislike,map,group,newLoc);
//                if(!assign(dislike,map,group,newLoc))   return false;
            }
        }


        return true;


    }

    public static int one(String str){
        int count = 0;

        int straight = 0;boolean lower = true;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>='A' && str.charAt(i)<='Z'){
//                if(cap>0)  count+=Math.min(cap,2);
//                cap = 0;
                if(lower==true){
                    if(straight<=2)
                        //不修改大小写
                        count+=straight;
                    else
                        count+=2;
                    straight = 1;lower = false;

                }else   straight++;

            }else{
                if(lower==false){
                    if(straight<=2)
                        //不修改大小写
                        count+=straight;
                    else
                        count+=2;
                    straight = 1;lower = true;
                }else straight++;


            }
            count++;
        }
//        if(Cap>0)   count+=Math.min(Cap,1);
//        if(cap>0 && cap<=2)   count+=Math.min(cap,1);

        return count;


    }
}