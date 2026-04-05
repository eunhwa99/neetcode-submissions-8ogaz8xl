class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    que.offer(new int[]{i,j,0});
                }
            }
        }
        bfs(que, grid);
    }

    void bfs(Queue<int[]> que, int[][] grid){
      
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        int INF = 2147483647;

        while(!que.isEmpty()){
    
            int[] top = que.poll();
            int cr = top[0];
            int cc = top[1];
            int dist = top[2];
            for(int d=0;d<4;d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || grid[nr][nc] != INF) continue;

                grid[nr][nc] = dist+1;
                que.offer(new int[]{nr,nc, dist+1});
            }
        }
    }
}
