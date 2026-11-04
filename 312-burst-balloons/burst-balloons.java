class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int []arr = new int[n+2];

        arr[0] = arr[n+1] = 1;
        for(int i = 0;i < n;i++){
            arr[i+1] = nums[i];
        }

        int [][]dp = new int[n+2][n+2];
        for(int[]row : dp){
            Arrays.fill(row,-1);
        }

        return maxBurstCoin(arr,0,n+1,dp);
    }
    public static int maxBurstCoin(int[]nums,int si,int ei,int[][]dp){
        if(si + 1 == ei){
            return 0;
        }

        if(dp[si][ei] != -1) return dp[si][ei];
        int ans = Integer.MIN_VALUE;

        for (int i = si+1; i < ei ; i++) {

            int l = maxBurstCoin(nums,si,i,dp);
            int r = maxBurstCoin(nums,i,ei,dp);

            int s = nums[si] * nums[i] * nums[ei];
            int totol = l + r + s;
            ans = Math.max(ans,totol);
        }

        return dp[si][ei] = ans;
    }
}