
import java.util.*;
public class kthSmallestInMatrix {

    public static void main(String[] args) {
//        int[] days = new int[]{1,4,6,7,8,20};
//        int[] costs = new int[]{7,2,15};
//        System.out.println(mincostTickets(days,costs));
        int[][] matrix = new int[][]{{1,3,5}, {6,7,12}, {11,14,14}};
        int[] nums = new int[]{2,-1,1,2,2};

        System.out.println(kthSmallest(matrix, 8));

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> retList=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                List<Integer> tmp=new ArrayList<>();
                tmp.add(nums1[i]+nums2[j]);
                tmp.add(nums1[i]);
                tmp.add(nums2[j]);
                retList.add(tmp);
            }
        }
        Collections.sort(retList,new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0)-o2.get(0);
            }
        });
        int min = k>retList.size()?retList.size():k;
        for(int i=0;i<min;i++){
            retList.get(i).remove(0);
        }
        return retList.subList(0, min);
    }


    public static int kthSmallest(int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Map.Entry<Integer,Integer>> q = new PriorityQueue<>(
                (a,b)->(matrix[a.getKey()][a.getValue()]-matrix[b.getKey()][b.getValue()]));

        q.offer(new AbstractMap.SimpleEntry(0,0));
        int count = 1;
        while(count<k){
            Map.Entry<Integer,Integer> entry = q.poll();
            System.out.println(matrix[entry.getKey()][entry.getValue()]);
            int row = entry.getKey();int col = entry.getValue();

            //offer new
            if(row<matrix.length-1 && !visited[row+1][col]){
                q.offer(new AbstractMap.SimpleEntry(row+1,col));visited[row+1][col] = true;
            }
            if(col<matrix[0].length-1 && !visited[row][col+1]) {
                q.offer(new AbstractMap.SimpleEntry(row, col + 1));visited[row][col+1] = true;
            }


            count++;
        }

        if(count==k){
            Map.Entry<Integer,Integer> entry = q.poll();
            return  matrix[entry.getKey()][entry.getValue()];
        }

        return -1;


    }
}
