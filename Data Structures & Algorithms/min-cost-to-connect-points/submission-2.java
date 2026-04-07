class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[] visited = new boolean[points.length];
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
              
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.computeIfAbsent(i, ArrayList::new).add(new int[]{dist, j});
                adj.computeIfAbsent(j, ArrayList::new).add(new int[]{dist, i});
            }
        }

        int count = 0, res=0;
        int N = points.length;
        que.offer(new int[]{0,0});

        while(!que.isEmpty()){
            int[] top = que.poll();
        
            if(count == N) break;
            if(visited[top[1]]) continue;
            count++;
            res+=top[0];
            visited[top[1]] = true;
            for (int[] nei : adj.getOrDefault(top[1], Collections.emptyList())) {
                int neiCost = nei[0];
                int neiIndex = nei[1];
                if (!visited[neiIndex]) {
                    que.offer(new int[]{neiCost, neiIndex});
                }
            }
        }
        return res;
    }
}
