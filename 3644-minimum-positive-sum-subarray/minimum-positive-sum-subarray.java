class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int sum=Integer.MAX_VALUE;
        int n=nums.size();
        for(int i=0;i<n;i++) {
            int s=0;
            for(int j=i;j<n&&j<i+r;j++) {
                s+=nums.get(j);
                if(j-i + 1>=l&&s>0){
                    sum=Math.min(sum,s);
                }
            }
        }
        if(sum!=Integer.MAX_VALUE) return sum;
        return -1;

    }
}