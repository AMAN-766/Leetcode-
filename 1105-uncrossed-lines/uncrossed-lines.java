class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length+1;
        int n = nums2.length+1;

        int [][]dp = new int[m][n];

        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){

                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }
}