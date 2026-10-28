class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> deq=new ArrayDeque<>();
        int[]arr=new int[n-k+1];
        int idx=0;
        for(int i=0;i<n;i++){
            while(!deq.isEmpty()&&deq.peekFirst()<=i-k){//maintain sizeof window removes extra element
                deq.pollFirst(); //remove extra element
            }
            while(!deq.isEmpty()&&nums[i]>nums[deq.peekLast()]){//remove indices whose value are smaller than num[i] and creates monotonic means decreasing values
                deq.pollLast(); // removes elemnet from last
            }
            deq.offerLast(i);
            if(i>=k-1){
                arr[idx++]=(nums[deq.peekFirst()]);//stores element in list when window size reaches k;
            }
        }
        return arr;
    }
}