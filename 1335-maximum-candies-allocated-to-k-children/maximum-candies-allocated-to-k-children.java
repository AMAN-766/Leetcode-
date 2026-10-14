class Solution {
    public int maximumCandies(int[] candies, long k) {
        int high = 0;
        for(int candy : candies){
            high = Math.max(candy,high);
        }

        int low = 1;

        int res = 0;
        while(low <= high){

            int mid = low + ( high - low)/2;
            if(isPossible(candies,mid,k)){
                res = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return res;
    }

    public boolean isPossible(int []arr, int mid,long k){
        long cnt = 0;
        for(int candy : arr){
            cnt += candy/mid;
        }
        return cnt >= k;
    }
}