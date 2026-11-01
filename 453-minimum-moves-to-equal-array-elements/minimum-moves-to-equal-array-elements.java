class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;

        int min = nums[0];
        for(int num : nums){
            min = Math.min(num,min);
        }

        int minOp = 0;

        for(int num : nums){
            minOp += num - min;

        }

        return minOp;
    }
}