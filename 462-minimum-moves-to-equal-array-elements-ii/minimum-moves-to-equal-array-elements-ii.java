class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[n/2];
        int c=0;
        for(int i = 0; i < n; i++) {
            c += Math.abs(nums[i] - ans);
        }
        return c;
    }
}