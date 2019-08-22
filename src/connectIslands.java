import java.util.*;

public class connectIslands {

    public static Map<Integer,Set<Integer>> groups = new HashMap<>();

    public static void main(String[] strs){



    }

    public static boolean canConnect(int[][] matrix,int islands){

        for(int[] tunnel:matrix){
            int A = tunnel[0];int B = tunnel[1];

            if(!groups.containsKey(A)){
                Set<Integer> set = new HashSet<>();set.add(B);
                groups.put(A,set);
            }
            if(!groups.containsKey(B)){
                Set<Integer> set = new HashSet<>();set.add(A);
                groups.put(B,set);
            }

            //update
            Set<Integer> Ahas = groups.get(A);Set<Integer> Bhas = groups.get(B);
            Ahas.addAll(Bhas);Bhas.addAll(Ahas);

            if(Ahas.size()>=(islands-1) || Bhas.size()>=(islands-1))    return true;
        }

        return false;

    }


//    public boolean canConnect(int[][] connects,int island){
//        List<Set<Integer>> groups = new LinkedList<>();
//
//        for(int[] connect:connects){
//            int A = connect[0];int B = connect[1];
//            boolean newgroup = true;
//            for(int i=0;i<groups.size();i++){
//                Set<Integer> set = groups.get(i);
//                if(set.contains(A)){
//
//                }
//                if(set.contains(B)){
//
//                }
//            }
//
//            if(newgroup){
//                //表明这两个暂时构成另一个集合，没有与已经联合的有关系
//                Set<Integer> newSet = new HashSet<>();
//                newSet.add(A);newSet.add(B);
//            }
//
//        }
//
//
//
//        return false;
//    }
}

//import java.util.*;
//
//public class Main {
//
//    public static Map<Integer,Set<Integer>> groups = new HashMap<>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int islands = sc.nextInt();int tunnels = sc.nextInt();
//        int[][] matrix = new int[tunnels][2];
//        //if(n==0 || m==0)    System.out.println(0);
//        for(int i = 0; i < tunnels; i++){
//            for(int j = 0; j < 2; j++){
//                matrix[i][j] = sc.nextInt();
//            }
//        }
//
//        System.out.println(canConnect(matrix,islands)?1:0);
//    }
//


//}
//
//
//
//
//public class Main {
//
//    public static Map<Integer,Set<Integer>> groups = new HashMap<>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();int n = sc.nextInt();
//        int[][] edges = new int[n][2];
//        //if(n==0 || m==0)    System.out.println(0);
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < 2; j++){
//                edges[i][j] = sc.nextInt();
//            }
//        }
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//        for(int []edge : edges) {
//            if(!map.containsKey(edge[0])) {
//                map.put(edge[0], new ArrayList<>());
//            }
//            map.get(edge[0]).add(edge[1]);
//
//            if(!map.containsKey(edge[1])) {
//                map.put(edge[1], new ArrayList<>());
//            }
//            map.get(edge[1]).add(edge[0]);
//        }
//        Set<Integer> visited = new HashSet<>();
//        for(int []edge : edges) {
//            dfs(map, edge[0], visited);
//        }
//        System.out.println( (visited.size() == m)?1:0);
//
//    }
//    private static void dfs(Map<Integer, List<Integer>> map, int start, Set<Integer> visited) {
//        if(!visited.add(start)) return;
//        for(Integer dest : map.getOrDefault(start, new ArrayList<>())) {
//            dfs(map, dest, visited);
//        }
//    }
//
//}
