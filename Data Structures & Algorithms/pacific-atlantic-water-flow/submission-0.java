class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] count = new int[heights.length][heights[0].length];
        Queue<int[]> que = new LinkedList<>();
        for(int i=0;i<heights[0].length;i++){ // pacific
            count[0][i] = 1;
            visited[0][i] = true;
            que.offer(new int[]{0,i});
        }

        for(int i=0;i<heights.length;i++){
            count[i][0] = 1;
            visited[i][0] = true;
            que.offer(new int[]{i,0});
        }
        
        bfs(que, count, visited, heights);

        visited = new boolean[heights.length][heights[0].length];
        
        for(int i=0;i<heights[0].length;i++){ // atlantic
            if(!visited[heights.length-1][i]){
                count[heights.length-1][i] += 1;
                visited[heights.length-1][i] = true;
                que.offer(new int[]{heights.length-1,i});
            }
        }

        for(int i=0;i<heights.length;i++){
            if(!visited[i][heights[0].length-1]){
                count[i][heights[0].length-1] += 1;
                visited[i][heights[0].length-1] = true;
                que.offer(new int[]{i,heights[0].length-1});
            }
        }

        bfs(que, count, visited, heights);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(count[i][j]==2){
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    void bfs(Queue<int[]> que, int[][] count, boolean[][] visited, int[][] heights){
        int[] dr = new int[]{0,1,0,-1};
        int[] dc = new int[]{1,0,-1,0};

        while(!que.isEmpty()){
            int[] top = que.poll();
            int cr = top[0];
            int cc = top[1];
            for(int d=0;d<4;d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if(nr<0||nr>=count.length||nc<0||nc>=count[0].length||visited[nr][nc]) continue;
                if(heights[nr][nc] < heights[cr][cc]) continue;
                visited[nr][nc] = true;
                count[nr][nc]+=1;
                que.offer(new int[]{nr, nc});
            }

        }
    }
}
