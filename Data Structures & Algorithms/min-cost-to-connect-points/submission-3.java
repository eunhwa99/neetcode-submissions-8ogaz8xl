class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        for(int i=0;i<points.length-1;i++){
            for(int j =i+1;j<points.length;j++){
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                int d = Math.abs(x1-x2) + Math.abs(y1-y2);

                que.offer(new int[]{d, i,j});
            }
        }
        int res = 0;
        int n = points.length;
        DSU dsu = new DSU(n);
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int dist = cur[0];
            if(dsu.union(cur[1], cur[2])){
                res+=dist;
            }
        }
        return res;
    }
}
class DSU{
    int[] Parent, Size;

    public DSU(int n){
        Parent = new int[n+1];
        Size = new int[n+1];
        for(int i=0;i<=n;i++){
            Parent[i] = i;
            Arrays.fill(Size, 1);
        }
    }

    public int find(int node){
        if(Parent[node]!=node){
            Parent[node] = find(Parent[node]);
        }

        return Parent[node];
    }

    public boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if(pu==pv) return false;
        if(Size[pu]<Size[pv]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        Size[pu] += Size[pv];
        Parent[pv] = pu;
        return true;
    }
}
