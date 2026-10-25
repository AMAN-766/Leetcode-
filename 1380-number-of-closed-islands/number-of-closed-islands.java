class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    if(check(grid,i,j)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public boolean check(int[][] grid,int r,int c){
        int n=grid.length;
        int m=grid[0].length;
        if(r<0||c<0||r>=n||c>=m){
            return false;
        }
        if(grid[r][c]==1){
            return true;
        }
        grid[r][c]=1 ;// mark current cell as 1 so it is not checked again
        boolean up=check(grid,r-1,c);
        boolean down=check(grid,r+1,c);
        boolean left=check(grid,r,c-1);
        boolean right=check(grid,r,c+1);
        return up && down && left && right;
    }
}