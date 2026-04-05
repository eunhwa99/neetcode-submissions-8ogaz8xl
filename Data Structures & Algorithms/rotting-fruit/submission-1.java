class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> que = new LinkedList<>();
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    que.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1) count+=1;
            }
        }
        return bfs(que, grid, count);
    }

    int bfs(Queue<int[]> que, int[][] grid, int oneCount){
        int[] dr = new int[]{1,0,-1,0};
        int[] dc = new int[]{0,1,0,-1};
        int dist = 0;
        int count = 0;
        while(!que.isEmpty()){
            int size = que.size();
            dist+=1;
            while(size-->0){
                int[] top = que.poll();
                int cr = top[0];
                int cc = top[1];
        
                for(int d=0;d<4;d++){
                    int nr = cr + dr[d];
                    int nc = cc + dc[d];
                    if(nr<0||nr>=grid.length||nc<0||nc>=grid[0].length||grid[nr][nc]!=1) continue;
                    grid[nr][nc]=2;
                    count+=1;
                    que.offer(new int[]{nr,nc});
                }
            }
        }
        dist = dist==0?dist:dist-1;
        return oneCount==count?dist:-1;
    }
}
