class Solution {
    // top down
    public int minDistance(String word1, String word2) {
        int [][]dp = new int[word1.length()+1][word2.length()+1];
        for(int []row : dp){
            Arrays.fill(row,-1);
        }
        return minOps(word1,word2,0,0,dp);
    }
    public int minOps(String s,String t,int i,int j ,int [][]dp){

        if(i == s.length()) return t.length() - j;
        if(j == t.length()) return s.length() - i;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = 0;
        if(s.charAt(i) == t.charAt(j)){
            ans = minOps(s,t,i+1,j+1,dp);
        }else{
            int d  = minOps(s,t,i+1,j,dp);
            int r  = minOps(s,t,i+1,j+1,dp);
            int in = minOps(s,t,i,j+1,dp);

            ans = Math.min(d,Math.min(r,in)) + 1;
        }

        return dp[i][j] = ans;
    }
}