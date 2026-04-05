class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=-1 && grid[i][j]!=0){
                    grid[i][j] = bfs(i,j,grid);
                }
            }
        }

    }

    int bfs(int r, int c, int[][] grid){
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r,c});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};

        int dist = 0;
        while(!que.isEmpty()){
            // Snapshot the queue size at the start of each iteration 
            // — nodes at the same level share the same distance from the source.
            int size = que.size();
            dist+=1;
            for(int i=0;i<size;i++){
                int[] top = que.poll();
                int cr = top[0];
                int cc = top[1];
                for(int d=0;d<4;d++){
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];

                    if(nr < 0 || nr >= grid.length || nc < 0 || nc >= grid[0].length || visited[nr][nc]||grid[nr][nc]==-1) continue;
                    if(grid[nr][nc]==0) return dist;
                    visited[nr][nc]=true;
                    que.offer(new int[]{nr,nc});
                }
                
            }
        }

        return dist;
    }
}
