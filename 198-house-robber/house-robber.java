class Solution {
    public int rob(int[] nums) {
        int[]dp=new int[nums.length];
        if(nums.length==1){
            return nums[0];
        }
        Arrays.fill(dp,-1);
        return total_rob(nums,dp);
    }
    public static int total_rob(int[]nums,int[]dp){
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            int rob=nums[i]+dp[i-2];
            int don_rob=dp[i-1];
            dp[i]=Math.max(rob,don_rob);
        }
        return dp[dp.length-1];
    }
}