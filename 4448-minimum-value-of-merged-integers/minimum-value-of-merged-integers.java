class Solution {
    public int minMergedInteger(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i += 2) {
            int a = nums[i];
            int b = nums[i + 1];
            String s = "" + a + b;
            int num = Integer.parseInt(s);
            ans = Math.min(ans, num);
        }
        return ans;
    }
}