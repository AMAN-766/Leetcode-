class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int [][] dp = new int[dungeon.length][dungeon[0].length];
        return calculateMinimum(dungeon,0,0,dp);
    }
    public static int calculateMinimum(int[][] dungeon, int cr, int cc, int[][] dp) {

        if(cr >= dungeon.length || cc >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }

        if(dp[cr][cc] != 0) return dp[cr][cc];

        if(cr == dungeon.length - 1 && cc == dungeon[0].length - 1){
            /*
            1 --> return 1 - dungeon[cr][cc];   but fail test case 37

                 hp = 1 - dungeon[cr][cc];
            2 -> return hp > 0 ? hp : 1;
            */

            // best way to return answer
            return Math.max(1,1 - dungeon[cr][cc]);
        }

        int ld = calculateMinimum(dungeon, cr, cc+1, dp);
        int rd = calculateMinimum(dungeon, cr+1, cc, dp);

        int HP = Math.min(ld,rd) - dungeon[cr][cc];

        return dp[cr][cc] = HP > 0 ? HP : 1;
    }
}