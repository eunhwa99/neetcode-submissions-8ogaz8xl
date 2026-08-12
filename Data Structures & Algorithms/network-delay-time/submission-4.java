class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] val: times){
            int start = val[0];
            int end = val[1];
            int time = val[2];
            adj.computeIfAbsent(start, ArrayList::new).add(new int[]{end, time});
        }

       dist[k-1] = 0;
       que.offer(new int[]{0, k});
        

        while(!que.isEmpty()){
            int[] val = que.poll();
            int time = val[0];
            int node = val[1];
            if(time > dist[node-1]) continue;

            for(int[] tmp: adj.getOrDefault(node, Collections.emptyList())){
                int nextTime = time + tmp[1];
                int nextNode = tmp[0];
                if(dist[nextNode-1] <= nextTime) continue;
                dist[nextNode-1] = nextTime;
                que.offer(new int[]{nextTime, nextNode});
            }
        }

        int res = 0;
        for(int d: dist){
            if(d == Integer.MAX_VALUE) return -1;
            res = Math.max(res, d);
        }

        return res;
        
    }
}
