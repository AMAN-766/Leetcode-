class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        Arrays.fill(dp,-1);
        int zero_th=climbing_stairs(cost,0,dp);
        int first=climbing_stairs(cost,1,dp);
        return Math.min(zero_th,first);
    }
    public int climbing_stairs(int[] arr,int i,int[] dp){
        if(i>=arr.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int f=climbing_stairs(arr,i+1,dp);
        int s=climbing_stairs(arr,i+2,dp);
        return dp[i]=Math.min(f,s)+arr[i];
    }
}