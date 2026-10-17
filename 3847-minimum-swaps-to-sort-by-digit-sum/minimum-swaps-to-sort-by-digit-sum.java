class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        // sum, digit
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i < n;i++){
            map.put(nums[i],i);
            int sum = DigitSum(nums[i]);
            pq.add(new int[]{sum,nums[i]});
        }

        int [] target = new int[n];
        int idx = 0;
        while(!pq.isEmpty()){
            target[idx++] = pq.remove()[1];
        }


        int count = 0;

        for(int i = 0;i < n;i++){

            if(nums[i] != target[i]){
                int id = map.get(target[i]);

                int temp = nums[id];
                nums[id] = nums[i];
                nums[i] = temp;

                map.put(nums[id], id);
                map.put(nums[i], i);
                
                count++;
            }
        }

        return count;


    }
    public int DigitSum(int n){
        int sum = 0;

        while(n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}