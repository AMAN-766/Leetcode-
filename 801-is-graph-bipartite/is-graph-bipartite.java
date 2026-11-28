class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        HashMap<Integer, Integer> color = new HashMap<>();
        int count=0;
        for(int key=0;key<graph.length;key++){
            if(visited.contains(key)){
                continue;
            }
            q.add(key);
            color.put(key, 0);
            while(!q.isEmpty()){
                int rp=q.poll();
                // ignore if already visited
                if(visited.contains(rp)){
                    count++;
                    continue;
                }
                //marked visited
                visited.add(rp);
                // add unvisited nbrs
                for(int nbrs:graph[rp]){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                     if(!color.containsKey(nbrs)) {
                        color.put(nbrs, 1 - color.get(rp));
                    }
                    else if(color.get(nbrs) == color.get(rp)) {
                        return false;
                    }
                }
            }
        }
        return true;
        
    }
}