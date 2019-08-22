//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.TreeMap;
//
///**
// * @author Qichao Ying
// * @date 2019/8/12 14:14
// * @Description DEFAULT
// */
//public class nextGreater {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int len = sc.nextInt();
//        int m = sc.nextInt();
//        int[] a = new int[len];
//        int[] b = new int[len];
//        for (int i = 0; i < len; i++) {
//            a[i] = sc.nextInt();
//        }
//        for (int i = 0; i < len; i++) {
//            b[i] = sc.nextInt();
//        }
//        int[] res = two(a, b, m, len);
//        StringBuilder str = new StringBuilder();
//        for (int in : res) {
//            str.append(in);
//            str.append(" ");
//        }
//
//        System.out.println(str.toString().trim());
//    }
//
//    static int[] res;
//
//    public static int[] two(int[] first, int[] second, int m, int len) {
//        res = new int[first.length];
//        List<Integer> remainFirst = new LinkedList<>();
//        List<Integer> remainSecond = new LinkedList<>();
//        for (int i = 0; i < first.length; i++) {
//            remainFirst.add(first[i]);
//            remainSecond.add(second[i]);
//        }
//        dfs(remainFirst, remainSecond, new LinkedList<>(), m, len);
//
//        return res;
//
//    }
//
//    public static void dfs(List<Integer> remainFirst, List<Integer> remainSecond, List<Integer> got, int m, int len) {
//        if (remainFirst.size() == 0) {
//            //compare
//            boolean update = false;
//            for (int i = 0; i < len; i++) {
//                if (got.get(i) < res[i]) break;
//                else if (got.get(i) > res[i]) {
//                    update = true;
//                    break;
//                }
//            }
//            if (update) {
//                for (int i = 0; i < len; i++) {
//                    res[i] = got.get(i);
//                }
//            }
//
//            return;
//        }
//
//        int largest = 0;
//        List<Integer> Aremove = new LinkedList<>();
//        List<Integer> Bremove = new LinkedList<>();
//        for (int i = 0; i < remainFirst.size(); i++) {
//            for (int j = 0; j < remainSecond.size(); j++) {
//                if ((remainFirst.get(i) + remainSecond.get(j)) % m == largest) {
//                    Aremove.add(i);
//                    Bremove.add(j);
//                } else if ((remainFirst.get(i) + remainSecond.get(j)) % m > largest) {
//                    Aremove = new LinkedList<>();
//                    Bremove = new LinkedList<>();
//                    largest = (remainFirst.get(i) + remainSecond.get(j)) % m;
//                    Aremove.add(i);
//                    Bremove.add(j);
//                }
//            }
//        }
//
//        got.add(largest);
//        for (int i = 0; i < Aremove.size(); i++) {
//            int A = remainFirst.get(Aremove.get(i));
//            int B = remainSecond.get(Bremove.get(i));
//            int Aind = Aremove.get(i);
//            int Bind = Bremove.get(i);
//            remainFirst.remove(Aind);
//            remainSecond.remove(Bind);
//            dfs(remainFirst, remainSecond, got, m, len);
//            remainFirst.add(Aremove.get(i), A);
//            remainSecond.add(Bremove.get(i), B);
//        }
//        got.remove(got.size() - 1);
//
//    }
//
//}
//
//    public static int surfaceArea(int[][] grid) {
//        int res = 0;
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]!=0){
//                    res+=2;
//                    if(i!=0)    res+=Math.max(0,grid[i][j]-grid[i-1][j]);
//                    else    res+=grid[i][j];
//                    if(i!=grid.length-1)    res+=Math.max(0,grid[i][j]-grid[i+1][j]);
//                    else    res+=grid[i][j];
//                    if(j!=0)    res+=Math.max(0,grid[i][j]-grid[i][j-1]);
//                    else    res+=grid[i][j];
//                    if(j!=grid[0].length-1)    res+=Math.max(0,grid[i][j]-grid[i][j+1]);
//                    else    res+=grid[i][j];
//                }
//            }
//        }
//        return res;
//    }
//
//    public static char nextGreatestLetter(char[] letters, char target) {
//        int left = 0;int right = letters.length;
//        while(left<right){
//            int mid = (left+right)/2;
//            if(letters[mid]<=target){left = mid+1;}
//            else right = mid-1;
//
//        }
//        if(left==letters.length)    return letters[letters.length-1];
//        if(letters[left]>target || left==letters.length-1)   return letters[left];
//        else return letters[left+1];
//
//    }
//
//    public static boolean isNStraightHand(int[] hand, int W) {
//        if(hand.length!=W*W)    return false;
//        TreeMap<Integer,Integer> map = new TreeMap<>();
//        for(int in:hand)    map.put(in,map.getOrDefault(in,0)+1);
//
//        int n = 0;
//        while(map.size()!=0 && n<W){
//            int floor = map.firstKey();
//            if(map.get(floor)!=1)
//                map.put(floor,map.get(floor)-1);
//            else  map.remove(floor);
//            for(int i=floor+1;i<floor+W;i++){
//                if(!map.containsKey(i))
//                    return false;
//                else{
//                    int num = map.get(i);
//                    if(num!=1)    map.put(i,num-1);
//                    else  map.remove(i);
//                }
//            }
//            n++;
//        }
//
//        return true;
//
//    }
//}
