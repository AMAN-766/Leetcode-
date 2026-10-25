class Solution {
    public long maximizeSum(int[] nums, int k) {
        long sum=0;
        long[] arr= new long[nums.length];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            ArrayList<Integer> ll= new ArrayList<>();
            int temp=nums[i];
            while(temp!=0){
                int a=temp%10;
                ll.add(a);
                temp/=10;
            }
            Collections.sort(ll);
            int max=0;
            for(int j=ll.size()-1;j>=0;j--){
                max=max*10+ll.get(j);
            }
            arr[i]=max-nums[i];
        }
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0 && k > 0; i--, k--) {
            sum += arr[i];
        }
        return sum;
    }
}