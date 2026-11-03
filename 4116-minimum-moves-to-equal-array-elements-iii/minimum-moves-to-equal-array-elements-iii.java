class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=nums[n-1];
        int c=0;
        for(int i=0;i<nums.length;i++){
            c+=Math.abs(nums[i]-max);
        }
        return c;
    }
}