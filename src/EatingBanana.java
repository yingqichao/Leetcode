class EatingBanana {
    public static void main(String[] args) {
        System.out.print(minEatingSpeed(new int[]{30,11,23,4,20},5));
    }
    public static int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for(int pile:piles) max = Math.max(max,pile);
        int left = 1;int right = max;
        while(left<=right){

            int mid = left+(right-left)/2;

            int hours = hours(piles,mid);
            if(hours<=H)    right = mid-1;
            else    left = mid+1;
        }

            if(hours(piles,right)>H)  return left;
            else return right;




    }

    public static int hours(int[] piles,int mid){
        int res = 0;
        for(int in:piles){
            res+=(int)Math.ceil(in/(double)mid);
        }

        return res;

    }
}