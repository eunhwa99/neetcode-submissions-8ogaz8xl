class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        pq.offer(new int[]{0,0,grid[0][0]});
        visited[0][0] = true; // push할 때 체크
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int cr = top[0];
            int cc = top[1];
            int time = top[2];
            if(cr==grid.length-1 && cc == grid[0].length-1) return time;
            for(int d=0;d<4;d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if(0>nr||nr>=grid.length|| 0>nc || nc>=grid[0].length||visited[nr][nc]) continue;
                int nextTime = grid[nr][nc] > time? grid[nr][nc]:time;
                visited[nr][nc] = true; // push할 때 확정
                pq.offer(new int[]{nr, nc, nextTime});
            }
        }
        return 0;
    }
}