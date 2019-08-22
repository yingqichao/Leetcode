import sun.awt.image.ImageWatched;

import java.util.*;

public class Ktimes {

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabbbdccccd",3));
    }

    public static int longestSubstring(String s, int k) {
        if(s.length()==0 || k==0)   return 0;int localMax = -1;


        Queue<int[]> queue= new LinkedList<>();Queue<int[]> back= new LinkedList<>();
        queue.offer(new int[]{0,s.length()});

        while(queue.size()!=0){
            int[] entry = queue.poll();
            int left = entry[0];int right = entry[1];
            int[] nums = new int[26];
            for(int i=left;i<right;i++)
                nums[s.charAt(i)-'a']++;
            boolean valid = true;
            for(int i=0;i<26;i++){
                if(nums[i]>0 && nums[i]<k){
                    valid = false;break;
                }
            }
            if(valid)   localMax =  Math.max(localMax,right-left);
            else{


                for (int i=left;i<right;i++) {
                    if (nums[s.charAt(i) - 'a'] < k) {
                        back.offer(new int[]{i+1,right});
                    }
                }

                for (int i=right-1;i>left;i--) {
                    if (nums[s.charAt(i) - 'a'] < k) {
                        back.offer(new int[]{left,i});
                    }
                }

//                queue.offer(new int[]{left+1,right});
//                queue.offer(new int[]{left,right-1});
            }
            if(queue.size()==0){
                //已经为空
                if(localMax!=-1)    return localMax;

                queue = back;back = new LinkedList<>();

            }

        }

        return 1;






    }

//    public int helper(String s,int left,int right,int k,int[] nums){
//        //check valid
//
//
//
//
//    }


}
