class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {

        // sorting base on time
        Arrays.sort(logs,(a,b) -> a[1] - b[1]);

        int [][] arr = new int[queries.length][2];

        for(int i = 0;i < queries.length;i++){
            arr[i][0]  = queries[i];  // queries
            arr[i][1]  = i;           // its index
        }

        // sorting base on duration
        Arrays.sort(arr,(a,b) -> a[0] - b[0]);

            // <server_id,count>
        HashMap<Integer,Integer> map = new HashMap<>();
        int[]res = new int[queries.length];

        int si = 0,ei = 0;

        for(int i = 0;i < arr.length;i++){

            int start = arr[i][0] - x;
            int end   = arr[i][0];

            // exit in time
            while(ei < logs.length && logs[ei][1] <= end){
                int id = logs[ei][0];
                map.put(id,map.getOrDefault(id,0)+1);
                ei++;
            }

            // less than time
            while(si < ei && logs[si][1] < start){

                int id = logs[si][0];
                map.put(id, map.get(id) - 1);
                if(map.get(id) == 0){
                    map.remove(id);
                }
                si++;
            }

            int count = n -  map.size();
            res[arr[i][1]] = count;
        }
        return res;
    }

}